package com.jcheng.plan;

import java.time.Duration;
import java.time.LocalDateTime;

public class NotSpringTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(1);
        Duration between = Duration.between(localDateTime,now );
        long l = between.toMillis();
        System.out.println((int)l);
    }
}
