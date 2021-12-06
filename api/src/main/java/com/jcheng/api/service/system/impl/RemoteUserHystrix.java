package com.jcheng.api.service.system.impl;

import com.jcheng.api.model.system.User;
import com.jcheng.api.service.system.RemoteUserService;
import com.jcheng.common.exception.CustomException;
import org.springframework.stereotype.Component;

@Component
public class RemoteUserHystrix implements RemoteUserService {
    @Override
    public User get(Integer userId) {
        throw new CustomException("用户id获取失败");
    }
}
