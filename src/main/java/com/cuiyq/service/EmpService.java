package com.cuiyq.service;

import com.cuiyq.domain.Emp;
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

    /**
     * 删除员工
     * @param ids
     */
    void deleteEmp(Integer[] ids);

    /**
     * 添加员工
     * @param emp
     */
    void addEmp(Emp emp);

    Emp getEmpById(Integer id);

    void updateEmp(Emp emp);

    Emp login(Emp emp);
}
