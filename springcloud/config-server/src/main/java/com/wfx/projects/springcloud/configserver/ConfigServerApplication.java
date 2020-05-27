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
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
