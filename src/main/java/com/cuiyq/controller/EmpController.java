package com.cuiyq.controller;

import com.cuiyq.domain.PageBean;
import com.cuiyq.domain.Result;
import com.cuiyq.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
public class EmpController {

    @Resource
    private EmpService empService;
    /**
     * 获取员工列表
     * @return
     */
    @GetMapping("/emps")
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {

        log.info("获取员工列表");
        PageBean pageBean = empService.list(page, pageSize);

        return Result.success(pageBean);
    }
}
