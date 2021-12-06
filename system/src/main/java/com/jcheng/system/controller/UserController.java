package com.jcheng.system.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import com.jcheng.api.model.system.User;
import com.jcheng.common.annotation.JWTIgnore;
import com.jcheng.common.domain.R;
import com.jcheng.common.exception.CustomException;
import com.jcheng.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 起凡
 * @since 2021-09-25
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @Validated User user) {
        userService.save(user);
        return R.ok(true);
    }

    @JWTIgnore
    @GetMapping("/get")
    @SaCheckRole("admin")
    public User get(Integer userId) {
        throw new CustomException("服务熔断测试");
//        return userService.getById(userId);
    }
}

