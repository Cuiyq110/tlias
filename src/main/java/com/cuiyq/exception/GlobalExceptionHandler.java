package com.cuiyq.exception;

import com.cuiyq.domain.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @version V1.0
 * @Title:
 * @Description: 定义全局异常处理器
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/18 11:17
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    //处理异常
    @ExceptionHandler(Exception.class) //指定能够处理的异常类型
    public Result ex(Exception e){
        e.printStackTrace();//打印堆栈中的异常信息

        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }
}
