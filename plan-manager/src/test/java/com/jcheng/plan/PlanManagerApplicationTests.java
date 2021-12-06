package com.jcheng.plan;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jcheng.plan.dao.ListMapper;
import com.jcheng.plan.model.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlanManagerApplicationTests {
    @Autowired
    ListMapper listMapper;
    @Test
    void contextLoads() {
        Page<List> listIPage=new Page<>(1,10);
        listMapper.findAll(listIPage,1);
    }

}
