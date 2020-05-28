# 摘要
Spring Cloud Config 可以为微服务架构中的应用提供集中化的外部配置支持，它分为服务端和客户端两个部分，本文将对其用法进行详细介绍。

## Spring Cloud Config 简介
Spring Cloud Config 分为服务端和客户端两个部分。
服务端被称为分布式配置中心，它是个独立的应用，可以从配置仓库获取配置信息并提供给客户端使用。客户端可以通过配置中心来获取配置信息，在启动时加载配置。
Spring Cloud Config 的配置中心默认采用Git来存储配置信息，所以天然就支持配置信息的版本管理，并且可以使用Git客户端来方便地管理和访问配置信息。

## 在Git仓库中准备配置信息
由于Spring Cloud Config 需要一个存储配置信息的Git仓库，这里我们先在Git仓库中添加好配置文件再演示其功能，Git仓库地址为：https://gitee.com/JourWon/springcloud-config

## 获取配置文件信息的访问格式
```
# 获取配置信息
/{label}/{application}-{profile}
# 获取配置文件信息
/{label}/{application}-{profile}.yml
```

## 占位符相关解释
application：代表应用名称，默认为配置文件中的spring.application.name，如果配置了spring.cloud.config.name，则为该名称；
label：代表分支名称，对应配置文件中的spring.cloud.config.label；
profile：代表环境名称，对应配置文件中的spring.cloud.config.profile。

## 获取配置信息演示
启动eureka-server、config-server服务；
访问http://localhost:8901/master/config-dev来获取master分支上dev环境的配置信息；



## config-sever集群搭建
在微服务架构中，所有服务都从配置中心获取配置，配置中心一旦宕机，会发生很严重的问题，下面我们搭建一个双节点的配置中心集群来解决该问题。


## 动态刷新配置
使用 Spring Cloud Bus 动态刷新配置需要配合 Spring Cloud Config 一起使用，我们使用上一节中的config-server、config-client模块来演示下该功能。



## 使用到的模块
springcloud
├── eureka-server -- eureka注册中心
├── config-server -- 配置中心服务
├── config-security-server -- 带安全认证的配置中心服务
└── config-client -- 获取配置的客户端服务


## 给config-server添加消息总线支持
在pom.xml中添加相关依赖：
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
配置文件application-amqp.yml
