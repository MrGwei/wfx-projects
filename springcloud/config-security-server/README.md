# 配置中心添加安全认证
我们可以通过整合SpringSecurity来为配置中心添加安全认证。

## 创建config-security-server模块
在pom.xml中添加相关依赖：
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

## application.yml配置文件
```
server:
  port: 8905

spring:
  application:
    name: config-security-server
  cloud:
    config:
      server:
        git:
          uri: https://github.com/MrGwei/ConfigFile
          username: MrGwei
          password: 
          search-paths: respo
          clone-on-start: true
  security:
    user:
      name: root
      password: root1234

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8001/eureka/
```


## ## config-sever集群搭建
在微服务架构中，所有服务都从配置中心获取配置，配置中心一旦宕机，会发生很严重的问题，下面我们搭建一个双节点的配置中心集群来解决该问题。
启动两个config-server分别运行在8902和8903端口上；
使用application-replica1.yml、application-replica2.yml