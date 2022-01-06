package com.jcheng.plan.service.auth;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jcheng.api.model.system.User;
import com.jcheng.api.service.system.RemoteAuthService;
import com.jcheng.common.constants.Constants;
import com.jcheng.common.constants.HttpStatus;
import com.jcheng.common.domain.R;
import com.jcheng.common.exception.CustomException;
import com.jcheng.common.utils.WeChatUtils;
import com.jcheng.plan.model.PmUser;
import com.jcheng.plan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class WeChatAuthImpl implements IAuthService<String> {
    @Autowired
    RemoteAuthService remoteAuthService;
    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public R<SaTokenInfo> signUp(String openId) throws Throwable {
        User user = new User();
        user.setUserName(RandomUtil.randomString(10));
        user.setNickName(user.getUserName());
        user.setPassword(RandomUtil.randomString(10));
        R<SaTokenInfo> res = remoteAuthService.signUp(user);
        if (res.getCode() == HttpStatus.ERROR) {
            throw new CustomException(res.getMsg());
        }
        PmUser pmUser = new PmUser();
        pmUser.setSysUserId(Integer.parseInt(res.getData().loginId.toString()));
        pmUser.setNickName(user.getUserName());
        pmUser.setOpenId(openId);
        userService.save(pmUser);
        return res;
    }

    @Override
    public R<SaTokenInfo> login(String code) throws Throwable {
        JSONObject session = WeChatUtils.getSession(code);
        String openId = (String) session.get("openid");
        Boolean isSet = redisTemplate.opsForValue().setIfAbsent("openId", openId, 5, TimeUnit.SECONDS);
        if (!isSet) {
            return null;
        }
        PmUser user = userService.getOne(Wrappers.<PmUser>lambdaQuery().eq(PmUser::getOpenId, openId));
        if (user == null) {
            return signUp(openId);
        }
        StpUtil.login(user.getSysUserId());
        SaSession saSession = StpUtil.getSession();
        saSession.set(Constants.WECHAT_SESSION, session);
        return R.ok(StpUtil.getTokenInfo());
    }
}
