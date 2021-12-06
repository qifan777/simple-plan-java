package com.jcheng.plan.service.impl;

import com.jcheng.plan.model.List;
import com.jcheng.plan.dao.ListMapper;
import com.jcheng.plan.service.ListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务列表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
@Service
public class ListServiceImpl extends ServiceImpl<ListMapper, List> implements ListService {

}
