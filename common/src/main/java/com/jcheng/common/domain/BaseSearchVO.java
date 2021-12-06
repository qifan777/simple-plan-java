package com.jcheng.common.domain;

import lombok.Data;

@Data
public class BaseSearchVO {
    String keyword;
    Integer pageSize;
    Integer pageNum;
}
