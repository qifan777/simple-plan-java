package com.jcheng.plan.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jcheng.common.constants.Constants;
import com.jcheng.common.constants.RedisKey;
import com.jcheng.common.exception.CustomException;
import com.jcheng.plan.model.Task;
import com.jcheng.plan.dao.TaskMapper;
import com.jcheng.plan.model.TaskUser;
import com.jcheng.plan.rabbitmq.MqConstants;
import com.jcheng.plan.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jcheng.plan.service.TaskUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
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
@Slf4j
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    TaskUserService taskUserService;
    @Autowired
    AmqpTemplate amqpTemplate;

    @Override
    public String share(Integer taskId) {
        String s = "share" + UUID.randomUUID();
        redisTemplate.opsForValue().set(RedisKey.TASK_SHARE_KEY + s, taskId, 60 * 15, TimeUnit.SECONDS);
        return s;
    }

    @Override
    public Boolean join(String key) {
        Integer taskId = (Integer) redisTemplate.opsForValue().get(RedisKey.TASK_SHARE_KEY + key);
        if (taskId == null) {
            throw new CustomException("任务不存在");
        }
        TaskUser one = taskUserService.getOne(Wrappers.<TaskUser>lambdaQuery().eq(TaskUser::getUserId, StpUtil.getLoginIdAsInt()).eq(TaskUser::getTaskId, taskId));
        if (one == null) {
            taskUserService.save(new TaskUser().setTaskId(taskId).setUserId(StpUtil.getLoginIdAsInt()));
        }
        return true;
    }

    @Override
    public void remind(Task task) {

        if (task.getIsSubscribe() != null && task.getIsSubscribe() && task.getRemindTime() != null && task.getUserId().equals(StpUtil.getLoginIdAsInt())) {
            Duration between = Duration.between(LocalDateTime.now(), task.getRemindTime());
            long l = between.toMillis();
            if (l > 0) {
                log.info("延迟了:" + l + "毫秒");
                amqpTemplate.convertAndSend(MqConstants.REMIND_EXCHANGE, MqConstants.REMIND_ROUTE, task, message -> {
                    log.info("发送订阅");
                    message.getMessageProperties().setDelay((int) l);
                    return message;
                });
            }

        }
    }
}
