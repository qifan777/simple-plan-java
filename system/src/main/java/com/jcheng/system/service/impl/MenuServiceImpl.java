package com.jcheng.system.service.impl;

import com.jcheng.api.model.system.Menu;
import com.jcheng.system.dao.MenuMapper;
import com.jcheng.system.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2021-09-25
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
