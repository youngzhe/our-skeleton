package com.our.exception;

import com.our.common.base.BaseEnums;
import com.our.common.base.Result;
import com.our.common.base.Results;
import com.our.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕捉自定义异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e) {
        log.error("捕捉业务数据异常:{}", e);
        return Results.failure(BaseEnums.FAILURE.code(), "业务处理失败");
    }

    /**
     * 除自定义异常外的其他异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result handleOtherException(Exception e) {
        log.error("捕捉其他异常:{}", e);
        return Results.failure(BaseEnums.FAILURE.code(), "内部数据错误");
    }

}
