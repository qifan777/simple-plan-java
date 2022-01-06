package com.jcheng.plan.service;

import com.jcheng.plan.model.Task;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 任务表 服务类
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
public interface TaskService extends IService<Task> {
    String share(Integer taskId);
    Boolean join(String key);
    void  remind(Task task);
}
