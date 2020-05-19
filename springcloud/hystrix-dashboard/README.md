# 摘要
Hystrix Dashboard 是Spring Cloud中查看Hystrix实例执行情况的一种仪表盘组件，支持查看单个实例和查看集群实例，本文将对其用法进行详细介绍。

## 简介
Hystrix提供了Hystrix Dashboard来实时监控HystrixCommand方法的执行情况。 
Hystrix Dashboard可以有效地反映出每个Hystrix实例的运行情况，帮助我们快速发现系统中的问题，从而采取对应措施。

## Hystrix Dashboard 图表解读
图表解读如下，需要注意的是，小球代表该实例健康状态及流量情况，颜色越显眼，表示实例越不健康，小球越大，表示实例流量越大。
曲线表示Hystrix实例的实时流量变化。

## Hystrix 集群实例监控
这里我们使用Turbine来聚合hystrix-service服务的监控信息，然后我们的hystrix-dashboard服务就可以从Turbine获取聚合好的监控信息展示给我们了。

## 创建一个turbine-service模块
用来聚合hystrix-service的监控信息。
使用application-replica1.yml配置再启动一个hystrix-service服务，启动turbine-service服务，此时注册中心显示如下。

### Hystrix集群监控演示
访问Hystrix Dashboard：http://localhost:8501/hystrix
添加集群监控地址，需要注意的是我们需要添加的是turbine-service的监控端点地址：
url:http://localhost:8601/turbine.stream
title:hystrix-service
调用几次hystrix-service的接口：http://localhost:8401/user/testCommand/1以及http://localhost:8402/user/testCommand/1
可以看到我们的Hystrix实例数量变成了两个。

## 使用到的模块
springcloud
├── eureka-server -- eureka注册中心
├── user-service -- 提供User对象CRUD接口的服务
├── hystrix-service -- hystrix服务调用测试服务
└── hystrix-dashboard -- 展示hystrix实例监控信息的仪表盘
