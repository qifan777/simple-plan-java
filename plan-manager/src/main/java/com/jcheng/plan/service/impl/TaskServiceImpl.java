package com.jcheng.plan.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jcheng.common.constants.Constants;
import com.jcheng.plan.model.Task;
import com.jcheng.plan.dao.TaskMapper;
import com.jcheng.plan.model.TaskUser;
import com.jcheng.plan.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jcheng.plan.service.TaskUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 任务表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    TaskUserService taskUserService;

    @Override
    public String share(Integer taskId) {
        String s = "share" + UUID.randomUUID();
        redisTemplate.opsForValue().set(Constants.TASK_SHARE_KEY + s, taskId, 60 * 15, TimeUnit.SECONDS);
        return s;
    }

    @Override
    public Boolean join(String key) {
        Integer taskId = (Integer) redisTemplate.opsForValue().get(Constants.TASK_SHARE_KEY + key);
        TaskUser one = taskUserService.getOne(Wrappers.<TaskUser>lambdaQuery().eq(TaskUser::getUserId, StpUtil.getLoginIdAsInt()).eq(TaskUser::getTaskId, taskId));
        if (one == null) {
            taskUserService.save(new TaskUser().setTaskId(taskId).setUserId(StpUtil.getLoginIdAsInt()));
        }
        return true;
    }
}
