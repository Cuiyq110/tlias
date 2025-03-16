package com.cuiyq.service;

import com.cuiyq.domain.PageBean;

import java.time.LocalDate;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/14 21:22
 */
public interface EmpService {

    PageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
}
