# 创建一个config-client模块来从config-server获取配置。
## 在pom.xml中添加相关依赖
```
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

## 在bootstrap.yml中进行配置
```
server:
port: 9001

spring:
application:
  name: config-client
cloud:
  # config客户端配置
  config:
    # 分支名称
    label: master
    # 启用配置后缀名称
    profile: dev
    # 配置文件名称
    name: config
    # 配置中心地址
    uri: http://localhost:8901

eureka:
client:
  register-with-eureka: true
  fetch-registry: true
  service-url:
    defaultZone: http://localhost:8001/eureka/
``` 

## 添加ConfigClientController类用于获取配置
```
@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
```

## 演示从配置中心获取配置
启动eureka-server、config-server、config-client服务
访问http://localhost:9001/configInfo，可以获取到dev分支下dev环境的配置；
```
config info for dev(master)
```

## 刷新配置
当Git仓库中的配置信息更改后，我们可以通过SpringBoot Actuator的refresh端点来刷新客户端配置信息，以下更改都需要在config-client中进行。 
在pom.xml中添加Actuator的依赖：
```   
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

## 在bootstrap.yml中开启refresh端点：
```   
management:
 endpoints:
   web:
     exposure:
       include: 'refresh'
```

## 在ConfigClientController类添加@RefreshScope注解用于刷新配置：
```
@RefreshScope
@RestController
```
重新启动config-client后，调用refresh端点进行配置刷新：
使用post请求http://localhost:9001/actuator/refresh

### IDEA>Services>choose service>Endpoints>Mappings>/actuator/refresh
```
POST http://localhost:9001/actuator/refresh

HTTP/1.1 200 OK
Connection: keep-alive
Transfer-Encoding: chunked
Content-Type: application/vnd.spring-boot.actuator.v3+json
Date: Thu, 21 May 2020 08:33:29 GMT

[
  "config.client.version",
  "config.info"
]

Response code: 200 (OK); Time: 12148ms; Content length: 39 bytes
```


## 添加bootstrap-security.yml配置文件，主要是配置了配置中心的用户名和密码：
```
server:
  port: 9002

spring:
  application:
    name: config-client-security
  cloud:
    # config客户端配置
    config:
      # 分支名称
      label: master
      # 启用配置后缀名称
      profile: dev
      # 配置文件名称
      name: config
      # 配置中心地址
      uri: http://localhost:8905/
      username: root
      password: root1234

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8001/eureka/

management:
  endpoints:
    web:
      exposure:
        include: 'refresh'

```
访问http://localhost:9002/configInfo进行测试，发现可以获取到配置信息。



## config-sever集群搭建
在微服务架构中，所有服务都从配置中心获取配置，配置中心一旦宕机，会发生很严重的问题，下面我们搭建一个双节点的配置中心集群来解决该问题。
启动两个config-server分别运行在8902和8903端口上；
```
server:
  port: 9003

spring:
  application:
    name: config-client
  cloud:
    # config客户端配置
    config:
      # 分支名称
      label: master
      # 启用配置后缀名称
      profile: dev
      # 配置文件名称
      name: config
      # config-sever集群搭建
      discovery:
        enabled: true
        service-id: config-server

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8001/eureka/

management:
  endpoints:
    web:
      exposure:
        include: 'refresh'
```