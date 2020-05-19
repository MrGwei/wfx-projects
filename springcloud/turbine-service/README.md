#Hystrix 集群实例监控
这里我们使用Turbine来聚合hystrix-service服务的监控信息，然后我们的hystrix-dashboard服务就可以从Turbine获取聚合好的监控信息展示给我们了。

## 创建一个turbine-service模块
用来聚合hystrix-service的监控信息。

## Hystrix集群监控演示
访问Hystrix Dashboard：http://localhost:8501/hystrix

## 使用到的模块
springcloud
├── eureka-server -- eureka注册中心
├── user-service -- 提供User对象CRUD接口的服务
├── hystrix-service -- hystrix服务调用测试服务
├── turbine-service -- 聚合收集hystrix实例监控信息的服务
└── hystrix-dashboard -- 展示hystrix实例监控信息的仪表盘
