package com.wfx.projects.springcloud.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication {

    /**
     * # 获取配置
     * http://localhost:8901/configInfo
     *
     * # 刷新配置
     * http://localhost:9001/actuator/refresh
     *
     *
     * security：
     * http://localhost:9001/configInfo
     *
     *
     * amqp
     * http://localhost:9004/configInfo
     * http://localhost:8904/actuator/bus-refresh
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
