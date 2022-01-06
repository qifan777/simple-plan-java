package com.jcheng.plan.service.auth;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.jcheng.api.model.system.User;
import com.jcheng.common.domain.R;

public interface IAuthService<T> {
    R<SaTokenInfo> signUp(T user) throws Throwable;
    R<SaTokenInfo> login(T user) throws Throwable;
}
