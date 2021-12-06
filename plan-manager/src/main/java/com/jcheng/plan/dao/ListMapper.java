package com.jcheng.plan.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jcheng.plan.model.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 任务列表 Mapper 接口
 * </p>
 *
 * @author 起凡
 * @since 2021-11-01
 */
@Repository
public interface ListMapper extends BaseMapper<List> {
    Page<List> findAll(Page<List> page, @Param("userId") Integer userId);

    List findOne(@Param("id") Integer id);

}
