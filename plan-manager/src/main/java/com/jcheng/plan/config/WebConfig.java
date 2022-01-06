package com.jcheng.plan.config;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import com.jcheng.common.interceptor.impl.SameUrlDataInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    SameUrlDataInterceptor sameUrlDataInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/v3/api-docs", "/swagger-resources/**", "/swagger-ui/");
        registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(sameUrlDataInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true).maxAge(3600);
    }
}
