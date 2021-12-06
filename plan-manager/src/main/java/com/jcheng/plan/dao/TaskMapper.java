package com.jcheng.plan.dao;

import com.jcheng.plan.model.Task;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 任务表 Mapper 接口
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
@Repository
public interface TaskMapper extends BaseMapper<Task> {
    Task findOne(Integer taskId);
    List<Task> sharedTasks(Integer userId);
}
