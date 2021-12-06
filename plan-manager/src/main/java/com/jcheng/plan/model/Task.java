package com.jcheng.plan.model;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 任务表
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("pm_task")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "task_id", type = IdType.AUTO)
    private Integer taskId;

    @NotBlank(message = "任务名不能为空")
    private String title;

    private String description;

    private Boolean checked;

    private LocalDateTime deadline;

    /**
     * 提醒日期
     */
    private LocalDateTime remindTime;

    /**
     * 附件
     */
    private String appendix;

    /**
     * 发布者ID
     */
    private Integer userId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    @TableLogic
    private Boolean deleted;

    @TableField(exist = false)
    private Integer listId;
    @TableField(exist = false)
    private List<Step> steps;
}
