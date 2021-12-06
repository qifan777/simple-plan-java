package com.jcheng.system.service.impl;

import com.jcheng.api.model.system.UserRole;
import com.jcheng.system.dao.UserRoleMapper;
import com.jcheng.system.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2021-09-25
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
