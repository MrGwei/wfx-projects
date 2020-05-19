学习Spring Cloud框架的总结，使用的是最新的Hoxton版本。主要包括Eureka、Ribbon、Hystrix、Feign、Zuul、Gateway、Security、Bus、OpenFeign等核心组件用法进行详细介绍。

参考：https://blog.csdn.net/ThinkWon/article/details/103715146

01.Eureka服务注册与发现
- eureka-server 服务注册中心，以及注册中心集群
- eureka-security-server 带登陆认证的安全注册服务中心
- eureka-client eureka客户端，配置文件有>注册到注册中心\注册中心集群\注册到安全注册中心

02.Ribbon服务消费者
- user-service 用于给Ribbon提供服务调用。
- ribbon-service 来调用user-service模块演示负载均衡的服务调用

03.Hystrix断路器
- hystrix-service 

04. 用来监控hystrix实例的执行情况。
- hystrix-dashboard 用来监控hystrix实例的执行情况。
- turbine-service 用来聚合hystrix-service的监控信息。

05. OpenFeign 是声明式的服务调用工具，它整合了Ribbon和Hystrix，拥有负载均衡和服务容错功能
- feign-service
