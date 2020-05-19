package com.wfx.projects.springcloud.feignservice.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gwei
 */
@Configuration
public class FeignLoggerConfig {

    @Bean
    Logger.Level level() {
        return Logger.Level.FULL;
    }
}
