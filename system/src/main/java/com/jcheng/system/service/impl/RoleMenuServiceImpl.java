package com.jcheng.system.service.impl;

import com.jcheng.api.model.system.RoleMenu;
import com.jcheng.system.dao.RoleMenuMapper;
import com.jcheng.system.service.RoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2021-09-25
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

}
