package com.our.common.exception;

/**
 * 业务处理异常类
 */
public class BusinessException extends RuntimeException{
    protected Integer errorCode;
    protected String errorMsg;

    public BusinessException(){

    }
    public BusinessException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
