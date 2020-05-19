package com.wfx.projects.springcloud.feignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignServiceApplication {

    /**
     * http://localhost:8701/user/1
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(FeignServiceApplication.class, args);
    }

}
