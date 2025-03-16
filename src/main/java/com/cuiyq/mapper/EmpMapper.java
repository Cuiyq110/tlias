package com.cuiyq.mapper;

import com.cuiyq.domain.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/14 21:09
 */
@Mapper
public interface EmpMapper {

//    List<Emp> getList(@Param("start") Integer start, @Param("pageSize") Integer pageSize);
//
//    Integer count();

//    分页查询使用插件
    List<Emp> getList();
}
