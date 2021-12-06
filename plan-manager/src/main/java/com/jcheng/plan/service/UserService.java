package com.jcheng.plan.service;

import com.jcheng.plan.model.PmUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
public interface UserService extends IService<PmUser> {
    Boolean signUp(PmUser pmUser);
}
