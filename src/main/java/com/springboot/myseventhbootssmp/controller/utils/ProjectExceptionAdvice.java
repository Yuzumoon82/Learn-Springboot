package com.springboot.myseventhbootssmp.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为 springmvc 的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
//    拦截所有异常信息
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex){
//    记录日志
//    通知运维
//    通知开发
        ex.printStackTrace();
        return new R("服务器异常，操作失败");
    }
}
