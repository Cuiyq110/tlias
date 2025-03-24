package com.cuiyq.aop;

import com.cuiyq.domain.OperateLog;
import com.cuiyq.mapper.OperateLogMapper;
import com.cuiyq.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/24 09:56
 */
@Slf4j
@Component
@Aspect
public class LogAspect {
    @Resource
    private HttpServletRequest request;
    @Resource
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.cuiyq.anno.Log)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
//        拿到操作人id
        String token = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(token);
        Integer operateUser = (Integer) claims.get("id");
//      操作时间
        LocalDateTime operateTime = LocalDateTime.now();
//      操作类名
        String className = joinPoint.getTarget().getClass().getName();
//      操作方法名
        String methodName = joinPoint.getSignature().getName();
//      操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = args.toString();

        Long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long end = System.currentTimeMillis();
        Long costTime = end - start;
        //      操作方法返回值
        String returnValue = result.toString();

//        插入日志
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);
        operateLogMapper.insert(operateLog);
        log.info("AOP记录操作日志: {}",operateLog);
        return result;
    }
}
