package com.jcheng.plan.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.jcheng.api.model.system.User;
import com.jcheng.common.annotation.JWTIgnore;
import com.jcheng.common.annotation.RepeatSubmit;
import com.jcheng.common.domain.R;
import com.jcheng.plan.service.auth.UsernamePasswordAuthImpl;
import com.jcheng.plan.service.auth.WeChatAuthImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    UsernamePasswordAuthImpl usernamePasswordAuthImpl;
    @Autowired
    WeChatAuthImpl weChatAuth;

    @JWTIgnore
    @PostMapping("login")
    public R<SaTokenInfo> login(@RequestBody @Validated User user) throws Throwable {
        return usernamePasswordAuthImpl.login(user);
    }

    @JWTIgnore
    @PostMapping("signUp")
    public R<SaTokenInfo> signUp(@RequestBody @Validated User user) throws Throwable {
        return usernamePasswordAuthImpl.signUp(user);
    }

    @JWTIgnore
    @GetMapping("/wechat/login")
    public R<SaTokenInfo> wechatLogin(@RequestParam String code) throws Throwable {
        return weChatAuth.login(code);
    }

}
