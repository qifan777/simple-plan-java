package com.jcheng.system.dao;

import com.jcheng.api.model.system.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author 起凡
 * @since 2021-09-25
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> listUserMenus(Integer userId);
}
