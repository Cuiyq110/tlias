package com.cuiyq.controller;

import com.cuiyq.domain.Emp;
import com.cuiyq.domain.Result;
import com.cuiyq.service.EmpService;
import com.cuiyq.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/17 10:41
 */
@Slf4j
@RestController
public class LoginController {

    @Resource
    private EmpService empService;
    /**
     * 登陆接口
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登陆，员工信息：{}", emp);
//        接收返回的员工信息
        Emp e = empService.login(emp);
       if (e != null) {
//           存储到token中
           Map<String, Object> claims = new HashMap<>();
           claims.put("id", e.getId());
           claims.put("username", e.getUsername());
           claims.put("name", e.getName());
           String empJwt = JwtUtils.generateJwt(claims);
           return Result.success(empJwt);
       }
       return Result.error("用户名或密码错误");
    }
}
