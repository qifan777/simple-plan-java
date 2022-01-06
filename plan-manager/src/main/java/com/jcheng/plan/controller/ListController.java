package com.jcheng.plan.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jcheng.common.domain.BaseSearchVO;
import com.jcheng.common.domain.R;
import com.jcheng.plan.dao.ListMapper;
import com.jcheng.plan.dao.ListTaskMapper;
import com.jcheng.plan.model.List;
import com.jcheng.plan.model.ListTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 * 任务列表 前端控制器
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
@RestController
@RequestMapping("/list")
@Slf4j
public class ListController {
    @Autowired
    ListMapper listMapper;
    @Autowired
    ListTaskMapper listTaskMapper;

    @PostMapping("save")
    @Transactional
    public R<Boolean> save(@RequestBody @Validated List list) {
        list.setUserId(StpUtil.getLoginIdAsInt());
        listMapper.insert(list);
        return R.ok(true);
    }

    @GetMapping("fineOne")
    public R<List> fineOne(Integer id) {
        return R.ok(listMapper.findOne(id));
    }

    @GetMapping("findAll")
    public R<Page<List>> findAll(BaseSearchVO baseSearchVO) {
        Page<List> listPage = new Page<>(baseSearchVO.getPageNum(), 100000);
        return R.ok(listMapper.findAll(listPage, StpUtil.getLoginIdAsInt()));
    }

    @PostMapping("update")
    public R<Boolean> update(@RequestBody @Validated List list) {
        listMapper.updateById(list);
        return R.ok(true);
    }

    @PostMapping("addTask")
    public R<Boolean> addTask(@Validated ListTask listTask) {
        listTaskMapper.insert(listTask);
        return R.ok(true);
    }

    @GetMapping("delete")
    public R<Boolean> delete(String ids) {
        String[] split = ids.split(",");
        listMapper.deleteBatchIds(Arrays.asList(split));
        return R.ok(true);
    }
}

