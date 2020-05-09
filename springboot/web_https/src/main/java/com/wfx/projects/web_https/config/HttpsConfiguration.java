package com.wfx.projects.web_https.config;

import io.undertow.Undertow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gwei
 */
@Configuration
public class HttpsConfiguration {

    @Value("${server.http.port}")
    private Integer httpPort;

    @Bean
    public ServletWebServerFactory undertowFactory() {
        UndertowServletWebServerFactory undertowFactory = new UndertowServletWebServerFactory();
        undertowFactory.addBuilderCustomizers((Undertow.Builder builder) -> {
            builder.addHttpListener(httpPort, "0.0.0.0");
        });
        return undertowFactory;
    }

}
