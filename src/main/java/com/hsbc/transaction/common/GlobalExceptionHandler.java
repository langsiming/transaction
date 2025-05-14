package com.hsbc.transaction.common;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * description:
 *
 * @author siminglang
 * @date 2025/5/13 19:28
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value =BusinessException.class)
    @ResponseBody
    public R<String> exceptionHandler(BusinessException e){
        return R.error(e.getMessage(), 500);
    }

    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public R<String> exceptionHandler(Exception e){
        return R.error(e.getMessage(), 500);
    }
}
