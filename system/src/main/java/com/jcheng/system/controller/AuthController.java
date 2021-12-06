package com.jcheng.system.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jcheng.api.model.system.User;
import com.jcheng.common.annotation.JWTIgnore;
import com.jcheng.common.domain.R;
import com.jcheng.common.exception.CustomException;
import com.jcheng.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"权限相关接口"})
@RestController
@RequestMapping("auth")
@Slf4j
public class AuthController {
    @Autowired
    UserService userService;

    @JWTIgnore
    @PostMapping("login")
    @Operation(description = "登录")
//    @ApiResponse(description = "登录成功",content = @Content(schema = @Schema(implementation = SaTokenInfo.class)))
    public R<SaTokenInfo> login(@RequestBody @Validated User user) {
        User one = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, user.getUserName()));
        if (one == null) {
            throw new CustomException("用户不存在");
        }
        String md5Password = SecureUtil.md5(user.getUserName() + user.getPassword());
        if (!md5Password.equals(one.getPassword())) {
            throw new CustomException("账号或密码错误");
        }
        StpUtil.login(one.getUserId());
        return R.ok(StpUtil.getTokenInfo());
    }

    @JWTIgnore
    @PostMapping("signUp")
    public R<SaTokenInfo> signUp(@RequestBody @Validated User user) {
        User one = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, user.getUserName()));
        if (one != null) {
            throw new CustomException("用户已存在");
        }
        user.setNickName("新用户");
        user.setPassword(SecureUtil.md5(user.getUserName() + user.getPassword()));
        userService.save(user);
        StpUtil.login(user.getUserId());
        log.info(StpUtil.getTokenInfo().toString());
        return R.ok(StpUtil.getTokenInfo());
    }

    @GetMapping("isLogin")
    public R<User> isLogin() {
        if (StpUtil.isLogin()) {
            return R.ok(userService.getById((String) StpUtil.getLoginId()));
        }
        return R.ok(null);
    }

    @GetMapping("getSession")
    public R<SaSession> getSession() {
        return R.ok(StpUtil.getSession());
    }

    @GetMapping("logout")
    public R<String> logout() {
        StpUtil.logout();
        return R.ok();
    }
}
