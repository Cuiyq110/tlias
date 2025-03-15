package com.cuiyq.service.impl;

import com.cuiyq.domain.Emp;
import com.cuiyq.domain.PageBean;
import com.cuiyq.mapper.EmpMapper;
import com.cuiyq.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;
    /**
     * 分页查询员工列表
     * 传递要看第几页，每页多少条数据，返回查询列表，总记录数
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageBean list(Integer page, Integer pageSize) {

//        返回查询列表
        Integer start = (page - 1) * pageSize;

        List<Emp> list = empMapper.getList(start, pageSize);
//        list.forEach(System.out::println);
        Integer total = empMapper.count();
        PageBean pageBean = new PageBean(total, list);
        return pageBean;
    }
}
