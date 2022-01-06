package com.jcheng.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "wechat")
@Component
public class WeChatKeys {
    String appId;
    String appSecret;
}
