package com.jcheng.api.service.system;

import com.jcheng.api.model.system.User;
import com.jcheng.api.service.system.impl.RemoteUserHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cloud-system", contextId = "user",url = "http://cloud-gateway/system", fallback = RemoteUserHystrix.class)
public interface RemoteUserService {
    @GetMapping("/user/get")
    User get(@RequestParam Integer userId);
}
