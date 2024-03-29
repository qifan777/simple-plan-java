package com.jcheng.plan.controller;


import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jcheng.api.model.system.User;
import com.jcheng.api.service.system.RemoteAuthService;
import com.jcheng.common.annotation.JWTIgnore;
import com.jcheng.common.annotation.RepeatSubmit;
import com.jcheng.common.constants.HttpStatus;
import com.jcheng.common.domain.R;
import com.jcheng.common.exception.CustomException;
import com.jcheng.plan.model.PmUser;
import com.jcheng.plan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    RemoteAuthService remoteAuthService;
    @Autowired
    UserService userService;

    @GetMapping("info")
    public R<PmUser> getUserInfo() {
        int loginIdAsInt = StpUtil.getLoginIdAsInt();
        return R.ok(userService.getOne(Wrappers.<PmUser>lambdaQuery().eq(PmUser::getSysUserId, loginIdAsInt)));
    }

    @PostMapping("update")
    public R<Boolean> update(@RequestBody PmUser user) {
        log.info(user.toString());
        userService.updateById(user);
        return R.ok(true);
    }
}

