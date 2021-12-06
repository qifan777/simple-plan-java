package com.jcheng.system.config;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import com.jcheng.api.model.system.Menu;
import com.jcheng.api.model.system.Role;
import com.jcheng.system.service.impl.MenuServiceImpl;
import com.jcheng.system.service.impl.RoleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    MenuServiceImpl menuService;

    @Override
    public List<String> getPermissionList(Object o, String s) {
        List<String> collect =(List<String>) StpUtil.getSession().get("permissions");
        if (collect==null){
            List<Menu> menus = menuService.getBaseMapper().listUserMenus(Integer.parseInt(o.toString()));
            collect = menus.stream().map(Menu::getPerms).collect(Collectors.toList());
            StpUtil.getSession().set("permissions", collect);
        }
        return collect;
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        List<String> collect =(List<String>) StpUtil.getSession().get("roles");
        if (collect==null){
            List<Role> menus = roleService.getBaseMapper().listUserRole(Integer.parseInt(o.toString()));
            collect = menus.stream().map(Role::getRoleKey).collect(Collectors.toList());
            StpUtil.getSession().set("roles", collect);
        }
        return collect;
    }
}
