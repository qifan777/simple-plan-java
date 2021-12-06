package com.jcheng.system.service.impl;

import com.jcheng.api.model.system.User;
import com.jcheng.system.dao.UserMapper;
import com.jcheng.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2021-09-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
