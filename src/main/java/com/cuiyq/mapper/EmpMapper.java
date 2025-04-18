package com.cuiyq.mapper;

import com.cuiyq.domain.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
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
    List<Emp> getList(@Param("name") String name, @Param("gender") Short gender,@Param("begin") LocalDate begin,@Param("end") LocalDate end);

    void deleteEmpByIds(@Param("ids") Integer[] ids);

    void insert(Emp emp);

    Emp getEmpById(Integer id);

    void updateEmp(Emp emp);

//    根据username 和 password 查询
    Emp selectByUsernameAndPassword(Emp emp);

    Integer deleteEmpByDeptId(Integer id);
}
