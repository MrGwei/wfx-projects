package com.wfx.projects.springcloud.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigServerApplication {

    /**
     * /{application}/{profile}[/{label}]
     * /{application}-{profile}.yml
     * /{label}/{application}-{profile}.yml
     * /{application}-{profile}.properties
     * /{label}/{application}-{profile}.properties
     * 占位符相关解释
     * application：代表应用名称，默认为配置文件中的spring.application.name，如果配置了spring.cloud.config.name，则为该名称；
     * label：代表分支名称，对应配置文件中的spring.cloud.config.label；
     * profile：代表环境名称，对应配置文件中的spring.cloud.config.profile。
     *
     *
     * http://localhost:8901/foo/dev
     * http://localhost:8901/server.port/dev
     * http://localhost:8901/zuul-dev.properties
     *
     * http://localhost:8901/master/config-dev 获取master分支上dev环境的配置信息
     * http://localhost:8901/master/config-dev.yml 获取具体配置文件
     *
     * http://localhost:8901/dev/config-dev 获取dev分支上dev环境的配置信息
     * http://localhost:8901/dev/config-dev.yml 获取具体配置文件
     *
     *
     * amqp
     * 调用注册中心的接口刷新所有配置：http://localhost:8904/actuator/bus-refresh
     * 刷新后再分别调用 http://localhost:9004/configInfo 和 http://localhost:9005/configInfo 获取配置信息，发现都已经刷新了；
     *
     * 如果只需要刷新指定实例的配置可以使用以下格式进行刷新：http://localhost:8904/actuator/bus-refresh/{destination} ，
     * 我们这里以刷新运行在9004端口上的config-client为例http://localhost:8904/actuator/bus-refresh/config-client:9004。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
