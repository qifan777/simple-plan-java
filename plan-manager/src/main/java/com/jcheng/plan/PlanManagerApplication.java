package com.jcheng.plan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = "com.jcheng")
@MapperScan("com.jcheng.plan.dao")
@EnableFeignClients(basePackages = "com.jcheng.api.service.system")
public class PlanManagerApplication {
    @PostConstruct
    void started() {
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        TimeZone.setDefault(timeZone);
    }

    public static void main(String[] args) {
        SpringApplication.run(PlanManagerApplication.class, args);
    }

}
