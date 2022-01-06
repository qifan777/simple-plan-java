package com.jcheng.plan.service.auth;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.jcheng.api.model.system.User;
import com.jcheng.api.service.system.RemoteAuthService;
import com.jcheng.common.constants.HttpStatus;
import com.jcheng.common.domain.R;
import com.jcheng.common.exception.CustomException;
import com.jcheng.plan.model.PmUser;
import com.jcheng.plan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsernamePasswordAuthImpl implements IAuthService<User> {
    @Autowired
    RemoteAuthService remoteAuthService;
    @Autowired
    UserService userService;

    @Override
    public R<SaTokenInfo> signUp(User user) throws Throwable {
        R<SaTokenInfo> res = remoteAuthService.signUp(user);
        if (res.getCode() == HttpStatus.ERROR) {
            throw new CustomException(res.getMsg());
        }
        PmUser pmUser = new PmUser();
        pmUser.setSysUserId(Integer.parseInt(res.getData().loginId.toString()));
        pmUser.setNickName(user.getUserName());
        userService.save(pmUser);
        return res;
    }

    @Override
    public R<SaTokenInfo> login(User user) throws Throwable {
        R<SaTokenInfo> res = remoteAuthService.login(user);
        if (res.getCode() == HttpStatus.ERROR) {
            throw new CustomException(res.getMsg());
        }
        return res;
    }
}
