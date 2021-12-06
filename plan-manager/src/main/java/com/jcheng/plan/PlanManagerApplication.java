package com.jcheng.plan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.jcheng")
@MapperScan("com.jcheng.plan.dao")
@EnableFeignClients(basePackages = "com.jcheng.api.service.system")
public class PlanManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanManagerApplication.class, args);
    }

}
