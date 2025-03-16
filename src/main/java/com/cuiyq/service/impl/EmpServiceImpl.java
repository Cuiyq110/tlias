package com.cuiyq.service.impl;

import com.cuiyq.domain.Emp;
import com.cuiyq.domain.PageBean;
import com.cuiyq.mapper.EmpMapper;
import com.cuiyq.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/14 21:22
 */

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;
    /**
     * 分页查询员工列表
     * 传递要看第几页，每页多少条数据，返回查询列表，总记录数
     *
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
//    @Override
//    public PageBean list(Integer page, Integer pageSize) {
//
////        返回查询列表
//        Integer start = (page - 1) * pageSize;
//
//        List<Emp> list = empMapper.getList(start, pageSize);
////        list.forEach(System.out::println);
//        Integer total = empMapper.count();
//        PageBean pageBean = new PageBean(total, list);
//        return pageBean;
//    }

    /**
     * 分页查询员工列表
     * 传递要看第几页，每页多少条数据，返回查询列表，总记录数

     */
    @Override
    public PageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
         PageHelper.startPage(page, pageSize);
        List<Emp> list = empMapper.getList(name, gender, begin, end);
        Page<Emp> empPage = (Page<Emp>) list;

        PageBean pageBean = new PageBean(empPage.getTotal(),empPage.getResult());
        return pageBean;
    }

    @Override
    public void deleteEmp(Integer[] ids) {

        empMapper.deleteEmpByIds(ids);
    }

    /**
     * 添加员工
     * @param emp
     */
    @Override
    public void addEmp(Emp emp) {
//        修改添加时间和更新时间
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);
    }

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @Override
    public Emp getEmpById(Integer id) {

//        获取员工信息
       Emp emp =  empMapper.getEmpById(id);
//        修改更新时间
        emp.setUpdateTime(LocalDateTime.now());
        return emp;
    }


}
