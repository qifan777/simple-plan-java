package com.jcheng.api.service.system;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.jcheng.api.model.system.User;
import com.jcheng.api.service.system.impl.RemoteAuthServiceHystrix;
import com.jcheng.common.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "cloud-system", contextId = "auth", url = "http://cloud-gateway/system", fallbackFactory = RemoteAuthServiceHystrix.class)
public interface RemoteAuthService {
    @PostMapping("/auth/login")
    R<SaTokenInfo> login(User user) throws Throwable;

    @PostMapping("/auth/signUp")
    R<SaTokenInfo> signUp(User user) throws Throwable;
}
