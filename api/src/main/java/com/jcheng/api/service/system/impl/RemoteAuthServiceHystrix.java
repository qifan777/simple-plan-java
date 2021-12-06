package com.jcheng.api.service.system.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.jcheng.api.model.system.User;
import com.jcheng.api.service.system.RemoteAuthService;
import com.jcheng.common.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RemoteAuthServiceHystrix implements FallbackFactory<RemoteAuthService> {
    @Override
    public RemoteAuthService create(Throwable cause) {
        return new RemoteAuthService() {
            @Override
            public R<SaTokenInfo> login(User user) throws Throwable {
                log.info(cause.getMessage());
                throw cause;
            }

            @Override
            public R<SaTokenInfo> signUp(User user) throws Throwable {
                log.info(cause.getMessage());
                throw cause;
            }
        };
    }
}
