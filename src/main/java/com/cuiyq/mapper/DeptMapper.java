package com.cuiyq.mapper;

import com.cuiyq.domain.Dept;
import com.cuiyq.domain.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/14 21:21
 */
@Mapper
public interface DeptMapper {


    List<Dept> list();

    Integer deleteDeptById(Integer id);

    Integer insert(Dept dept);
}
