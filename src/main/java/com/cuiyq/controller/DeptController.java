package com.cuiyq.controller;

import com.cuiyq.anno.Log;
import com.cuiyq.domain.Dept;
import com.cuiyq.domain.Result;
import com.cuiyq.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Resource
    private DeptService deptService;

    @PutMapping
    public Result updateDept(@RequestBody Dept dept) {
        log.info("修改部门：{}", dept);
        deptService.updateDept(dept);
        return Result.success();
    }

    /**
     * 查询部门列表
     * @return
     */
    @GetMapping
    public Result List() {
        log.info("查询部门列表");
        List<Dept> list = deptService.list();

        return Result.success(list);
    }


    /**
     * 根据id删除部门
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable Integer id) throws Exception {

        Integer i = deptService.deleteDept(id);
        log.info("删除结果：{}", i);
        return Result.success();
    }

    @PostMapping
    public Result addDept(@RequestBody Dept dept) {
        log.info("新增部门：{}", dept);
        deptService.addDept(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getDept( @PathVariable Integer id) {
        log.info("根据id查询部门：{}", id);
       Dept dept =  deptService.getDeptById(id);
        return Result.success(dept);
    }

}
