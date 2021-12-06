package com.jcheng.system.service.impl;

import com.jcheng.api.model.system.Role;
import com.jcheng.system.dao.RoleMapper;
import com.jcheng.system.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2021-09-25
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
