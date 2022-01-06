package com.jcheng.plan.service.impl;

import com.jcheng.plan.model.PmUser;
import com.jcheng.plan.dao.UserMapper;
import com.jcheng.plan.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, PmUser> implements UserService {


}
