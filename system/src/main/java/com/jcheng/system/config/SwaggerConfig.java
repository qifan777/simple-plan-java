package com.jcheng.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {
    @Bean
    public Docket authApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("auth").select()
                .apis(RequestHandlerSelectors.basePackage("com.jcheng.system.controller"))
                .paths(PathSelectors.regex("/auth/.*")).build();
    }
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("user").select()
                .apis(RequestHandlerSelectors.basePackage("com.jcheng.system.controller"))
                .paths(PathSelectors.regex("/user/.*")).build();
    }
}
