package com.wfx.projects.springcloud.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
public class HystrixDashboardApplication {

    /**
     * http://localhost:8501/hystrix
     *  >http://localhost:8401/actuator/hystrix.stream
     *  >hystrix-service
     *
     *  >http://localhost:8601/turbine.stream
     *  >hystrix-service
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }

}
