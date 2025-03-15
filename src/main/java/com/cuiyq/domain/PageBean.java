package com.cuiyq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @version V1.0
 * @Title: 员工查询返回数据
 * @Description:
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/15 18:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {

    private Integer total;
    private List rows;
}
