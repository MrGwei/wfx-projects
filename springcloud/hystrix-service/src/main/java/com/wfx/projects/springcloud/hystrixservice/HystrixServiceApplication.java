package com.wfx.projects.springcloud.hystrixservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// 开启Hystrix的断路器功能
@EnableCircuitBreaker
@EnableDiscoveryClient
public class HystrixServiceApplication {

    /**
     * http://localhost:8401/user/testFallback/1
     *
     *
     * http://localhost:8401/user/testException/1 异常处理导致服务降级
     * http://localhost:8401/user/testException/2 异常未处理，服务未降级
     *
     *
     * http://localhost:8401/user/testCache/1 测试使用缓存
     * http://localhost:8401/user/testRemoveCache/1 测试移除缓存
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(HystrixServiceApplication.class, args);
    }

}
