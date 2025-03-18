package com.cuiyq.service.impl;

import com.cuiyq.domain.Dept;
import com.cuiyq.domain.Emp;
import com.cuiyq.mapper.DeptMapper;
import com.cuiyq.mapper.EmpMapper;
import com.cuiyq.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/14 21:23
 */
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Resource
    private EmpMapper  empMapper;
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
     * 解散部门删除员工
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Integer deleteDept(Integer id) {


        Integer i = deptMapper.deleteDeptById(id);
//        int ai = 1 / 0;
//        根据部门删除员工
        Integer emp = empMapper.deleteEmpByDeptId(id);
        log.info("删除结果：{}", emp);
        return i;

    }

    /**
     * 添加部门
     * @param dept
     * @return
     */
    @Override
    public Integer addDept(Dept dept) {
//        设置创建日期和更新日期
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        Integer i = deptMapper.insert(dept);
        return  i;
    }

    @Override
    public Dept getDeptById(Integer id) {
      Dept dept = deptMapper.getDeptById(id);
      return dept;
    }

    @Override
    public void updateDept(Dept dept) {
        deptMapper.updateDept(dept);
    }
}
