package com.our.ourweb.exception;

import com.our.common.base.BaseEnums;
import com.our.common.base.Result;
import com.our.common.base.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public Result handleMediaException(Throwable e) {
        log.error("捕捉其他异常:{}", e);
        return Results.failure(BaseEnums.FAILURE.code(), "请求失败");
    }


}
