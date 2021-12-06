package com.jcheng.system.dao;

import com.jcheng.api.model.system.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author 起凡
 * @since 2021-09-25
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> listUserRole(Integer userId);
}
