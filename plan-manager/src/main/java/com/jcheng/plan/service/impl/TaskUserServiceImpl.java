package com.jcheng.plan.service.impl;

import com.jcheng.plan.model.TaskUser;
import com.jcheng.plan.dao.TaskUserMapper;
import com.jcheng.plan.service.TaskUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务成员关系表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
@Service
public class TaskUserServiceImpl extends ServiceImpl<TaskUserMapper, TaskUser> implements TaskUserService {

}
