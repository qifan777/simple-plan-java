package com.jcheng.plan.service.impl;

import com.jcheng.plan.model.Step;
import com.jcheng.plan.dao.StepMapper;
import com.jcheng.plan.service.StepService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务步骤表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
@Service
public class StepServiceImpl extends ServiceImpl<StepMapper, Step> implements StepService {

}
