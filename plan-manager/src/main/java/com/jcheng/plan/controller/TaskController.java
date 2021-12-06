package com.jcheng.plan.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jcheng.common.domain.BaseSearchVO;
import com.jcheng.common.domain.R;
import com.jcheng.common.exception.CustomException;
import com.jcheng.plan.dao.TaskMapper;
import com.jcheng.plan.model.ListTask;
import com.jcheng.plan.model.Step;
import com.jcheng.plan.model.Task;
import com.jcheng.plan.model.TaskUser;
import com.jcheng.plan.service.ListTaskService;
import com.jcheng.plan.service.StepService;
import com.jcheng.plan.service.TaskService;
import com.jcheng.plan.service.TaskUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 任务表 前端控制器
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    ListTaskService listTaskService;
    @Autowired
    TaskUserService taskUserService;
    @Autowired
    StepService stepService;

    @PostMapping("save")
    @Transactional
    public R<Boolean> save(@RequestBody @Validated Task task) {
        task.setUserId(StpUtil.getLoginIdAsInt());
        taskService.save(task);
        task.getSteps().forEach(step -> step.setTaskId(task.getTaskId()));
        stepService.saveBatch(task.getSteps());
        listTaskService.save(new ListTask().setTaskId(task.getTaskId()).setListId(task.getListId()));
        return R.ok(true);
    }

    @GetMapping("fineOne")
    public R<Task> fineOne(Integer id) {
        return R.ok(taskMapper.findOne(id));
    }

    @GetMapping("findAll")
    public R<Page<Task>> findAll(BaseSearchVO baseSearchVO) {
        Page<Task> taskPage = new Page<>(baseSearchVO.getPageNum(), baseSearchVO.getPageSize());
        return R.ok(taskService.page(taskPage, Wrappers.<Task>lambdaQuery().eq(Task::getUserId, StpUtil.getLoginIdAsInt())));
    }

    @GetMapping("delete")
    public R<Boolean> delete(String ids) {
        String[] split = ids.split(",");
        taskService.removeByIds(Arrays.asList(split));
        return R.ok(true);
    }

    @PostMapping("update")
    @Transactional
    public R<Boolean> update(@RequestBody Task task) {
        if (task.getSteps() != null) {
            stepService.remove(Wrappers.<Step>lambdaQuery().eq(Step::getTaskId, task.getTaskId()));
            task.getSteps().forEach(step -> step.setTaskId(task.getTaskId()));
            stepService.saveBatch(task.getSteps());
        }
        taskService.updateById(task);
        return R.ok(true);
    }

    @GetMapping("deleteRelation")
    public R<Boolean> deleteRelation(Integer taskId, Integer listId) {
        int loginIdAsInt = StpUtil.getLoginIdAsInt();
        taskUserService.remove(Wrappers.<TaskUser>lambdaQuery().eq(TaskUser::getTaskId, taskId).eq(TaskUser::getUserId, loginIdAsInt));
        listTaskService.remove(Wrappers.<ListTask>lambdaQuery().eq(ListTask::getTaskId, taskId).eq(ListTask::getListId, listId));
        return R.ok(true);
    }

    @GetMapping("share")
    public R<String> share(Integer taskId) {
        Task task = taskService.getById(taskId);
        if (!task.getUserId().equals(StpUtil.getLoginIdAsInt())){
            throw new CustomException("权限不足无法分享");
        }
        return R.ok(taskService.share(taskId));
    }

    @GetMapping("join")
    public R<Boolean> join(String key) {
        return R.ok(taskService.join(key));
    }

    @GetMapping("sharedTasks")
    public R<List<Task>> sharedTasks() {
        int loginIdAsInt = StpUtil.getLoginIdAsInt();
        return R.ok(taskMapper.sharedTasks(loginIdAsInt));
    }
}

