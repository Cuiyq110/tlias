package com.cuiyq.service.impl;

import com.cuiyq.domain.Dept;
import com.cuiyq.domain.Emp;
import com.cuiyq.mapper.DeptMapper;
import com.cuiyq.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/14 21:23
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;
    /**
     * 查询所有部门
     *
     * @return
     */
    @Override
    public List<Dept> list() {

        return deptMapper.list();
    }

    /**
     * 根据id删除部门
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteDept(Integer id) {
       return deptMapper.deleteDeptById(id);
    }
}
