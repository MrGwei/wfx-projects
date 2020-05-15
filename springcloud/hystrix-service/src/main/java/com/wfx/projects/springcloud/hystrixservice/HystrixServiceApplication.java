package com.wfx.projects.springcloud.hystrixservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
public class HystrixServiceApplication {

    /**
     * http://localhost:8401/user/testFallback/1
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(HystrixServiceApplication.class, args);
    }

}
