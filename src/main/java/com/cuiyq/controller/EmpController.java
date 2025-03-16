package com.cuiyq.controller;

import com.cuiyq.domain.PageBean;
import com.cuiyq.domain.Result;
import com.cuiyq.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Arrays;

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
@RequestMapping("/emps")
public class EmpController {

    @Resource
    private EmpService empService;

    @DeleteMapping("/{ids}")
    public Result deleteEmp(@PathVariable Integer[] ids) {

        log.info("删除员工：{}", Arrays.toString(ids));
        empService.deleteEmp(ids);
        return Result.success();
    }

    /**
     * 获取员工列表
     * @return
     */
    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {

        log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.list(page, pageSize, name, gender, begin, end);

        return Result.success(pageBean);
    }
}
