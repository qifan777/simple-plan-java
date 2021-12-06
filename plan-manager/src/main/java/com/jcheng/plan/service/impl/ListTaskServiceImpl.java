package com.jcheng.plan.service.impl;

import com.jcheng.plan.model.ListTask;
import com.jcheng.plan.dao.ListTaskMapper;
import com.jcheng.plan.service.ListTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 列表任务关系表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
@Service
public class ListTaskServiceImpl extends ServiceImpl<ListTaskMapper, ListTask> implements ListTaskService {

}
