package com.cuiyq.controller;

import com.cuiyq.domain.Emp;
import com.cuiyq.domain.Result;
import com.cuiyq.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class DeptController {

    @Resource
    private DeptService deptService;
    /**
     * 查询部门列表
     * @return
     */
    @GetMapping("/depts")
    public Result List() {
        log.info("查询部门列表");
        List<Emp> list = deptService.list();
        return Result.success(list);
    }
}
