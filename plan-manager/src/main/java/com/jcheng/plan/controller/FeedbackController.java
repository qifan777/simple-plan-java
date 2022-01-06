package com.jcheng.plan.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.jcheng.common.domain.R;
import com.jcheng.plan.model.Feedback;
import com.jcheng.plan.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 反馈表 前端控制器
 * </p>
 *
 * @author 起凡
 * @since 2021-12-09
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @PostMapping("save")
    public R<Boolean> save(@RequestBody @Validated Feedback feedback) {
        feedback.setUserId(StpUtil.getLoginIdAsInt());
        feedbackService.save(feedback);
        return R.ok(true);
    }
}

