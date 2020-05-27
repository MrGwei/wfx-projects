学习Spring Cloud框架的总结，使用的是最新的Hoxton版本。主要包括Eureka、Ribbon、Hystrix、Feign、Zuul、Gateway、Security、Bus、OpenFeign等核心组件用法进行详细介绍。

参考：https://blog.csdn.net/ThinkWon/article/details/103715146
## 简介
Spring Cloud是一系列框架的有序集合。目的是协调各个微服务，简化分布式系统开发。这里做一个有关于Spring Cloud知识的汇总，包括Spring Cloud核心组件、Spring Cloud Alibaba及分布式事务Seata，使用的版本是Spring Cloud Hoxton及SpringBoot 2.2.x。

应用场景
## 注册中心
注册中心主要用于服务治理，提供了服务的注册与发现功能，微服务架构中的服务可以注册到注册中心，也可以通过注册中心获取到其他服务的信息。这里提供了Eureka、Consul、Nacos三种解决方案。

## 配置中心
配置中心主要用于提供统一的外部配置管理，微服务架构中的服务可以从配置中心获取配置信息，同时支持动态刷新配置。这里提供了Spring Cloud Config、Consul、Nacos三种解决方案。

## 服务网关
API网关主要用于为微服务架构中的服务提供统一的外部访问入口，实现请求的路由与过滤功能。这里提供了Zuul和Gateway两种解决方案。

## 服务调用
微服务架构中有的服务会部署多个，Ribbon提供了服务间调用的客户端负载均衡功能，OpenFeign基于Ribbon提供了声明式的服务间调用。

## 熔断与限流
熔断与限流是对微服务架构中服务的一种保护措施，当系统中有故障发生时，可以防止故障的蔓延。这里提供了Hystrix和Sentinel两种解决方案。

## 安全保护
Spring Cloud Security 为构建安全的SpringBoot应用提供了一系列解决方案，结合Oauth2可以实现单点登录、服务安全保护等功能，可以很好地保护微服务架构中的服务。

## 监控中心
Spring Boot Admin 结合 Spring Cloud的注册中心使用可以用来监控微服务架构中的服务。

## 分布式事务解决
微服务架构中，当一次业务操作需要操作多个数据源或需要进行远程调用时就会产生分布式事务问题，Seata可以很好地解决该问题。

## 项目结构
springcloud
├── eureka-server -- eureka注册中心
├── eureka-security-server -- 带登录认证的eureka注册中心
├── eureka-client -- eureka客户端
├── user-service -- 提供User对象CRUD接口的服务
├── ribbon-service -- ribbon服务调用测试服务
├── hystrix-service -- hystrix服务调用测试服务
├── turbine-service -- 聚合收集hystrix实例监控信息的服务
├── hystrix-dashboard -- 展示hystrix实例监控信息的仪表盘
├── feign-service -- feign服务调用测试服务
├── zuul-proxy -- zuul作为网关的测试服务
├── config-server -- 配置中心服务
├── config-security-server -- 带安全认证的配置中心服务
├── config-client -- 获取配置的客户端服务
├── consul-config-client -- 用于演示consul作为配置中心的consul客户端
├── consul-user-service -- 注册到consul的提供User对象CRUD接口的服务
├── consul-service -- 注册到consul的ribbon服务调用测试服务
├── api-gateway -- gateway作为网关的测试服务
├── admin-server -- admin监控中心服务
├── admin-client -- admin监控中心监控的应用服务
├── admin-security-server -- 带登录认证的admin监控中心服务
├── oauth2-server -- oauth2授权测试服务
├── oauth2-jwt-server -- 使用jwt的oauth2授权测试服务
├── oauth2-client -- 单点登录的oauth2客户端服务
├── nacos-config-client -- 用于演示nacos作为配置中心的nacos客户端
├── nacos-user-service -- 注册到nacos的提供User对象CRUD接口的服务
├── nacos-ribbon-service -- 注册到nacos的ribbon服务调用测试服务
├── sentinel-service -- sentinel功能测试服务
├── seata-order-service -- 整合了seata的订单服务
├── seata-storage-service -- 整合了seata的库存服务
└── seata-account-service -- 整合了seata的账户服务



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

06. Zuul服务网关
- zuul-proxy 提供了统一的访问入口

07. 配置中心服务
- config-server 配置中心服务
- config-client 获取配置的客户端服务
- config-security-server 带安全认证的配置中心服务


