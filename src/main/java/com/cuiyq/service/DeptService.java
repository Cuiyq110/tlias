package com.cuiyq.service;

import com.cuiyq.domain.Dept;
import com.cuiyq.domain.Emp;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/14 21:22
 */

public interface DeptService {
    List<Dept> list();

    Integer deleteDept(Integer id);

    Integer addDept(Dept dept);
}
