package com.jcheng.plan.model;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 任务列表
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("pm_list")
public class List implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "list_id", type = IdType.AUTO)
    private Integer listId;

    /**
     * 标题
     */
    private String title;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime updateTime;

    @TableLogic
    private Boolean deleted;
    @TableField(exist = false)
    java.util.List<Task> tasks;
}
