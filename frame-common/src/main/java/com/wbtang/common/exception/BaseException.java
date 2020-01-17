package com.wbtang.common.exception;

import com.wbtang.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用异常封装类,通过抓取不同的错误实现对不同错误的不同处理
 *
 * @author TangWenBo
 * @date 2019/12/26
 */
@ControllerAdvice
@Slf4j
public class BaseException {


    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public Result baseException(HttpServletRequest request, Throwable ex) {
        String requestURI = request.getRequestURL().toString();
        log.error("{}请求失败,原因:{}", requestURI, ex.toString());
        return Result.error();
    }


    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public Result numEx(HttpServletRequest request, Throwable ex) {
        log.error("会不会算数啊??:{}", ex.toString());
        System.out.println(ex.toString());
        return Result.fail("数学没学好啊兄弟!");
    }
}
