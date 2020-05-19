package com.wfx.projects.springcloud.zuulproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 添加@EnableZuulProxy注解来启用Zuul的API网关功能
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulProxyApplication {

    /**
     * http://localhost:8801/userService/user/1
     * http://localhost:8801/feignService/user/1
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ZuulProxyApplication.class, args);
    }

}
