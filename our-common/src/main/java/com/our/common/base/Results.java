package com.our.common.base;


/**
 * @ClassName Results
 * @Description TODO
 * @Author shaozhenjun
 * @Date 19-7-9 下午4:19
 * @Version 1.0
 */
public class Results {
    public static <T> Result success() {
        return new Result<T>(true, BaseEnums.SUCCESS.code());
    }

    public static <T> Result success(String msg) {
        return new Result<T>(true, BaseEnums.SUCCESS.code(), msg);
    }

    public static <T> Result success(Integer code, String msg) {
        return new Result<T>(true, code, msg);
    }

    public static <T> Result successWithStatus(Integer status) {
        return new Result<T>(true, status);
    }

    public static <T> Result successWithStatus(Integer status, String msg) {
        return new Result<T>(true, status, BaseEnums.SUCCESS.code(), msg);
    }

    public static <T> Result successWithData(T data) {
        return new Result<T>(true, null, BaseEnums.SUCCESS.code(), null, data);
    }

    public static <T> Result successWithData(String msg, T data) {
        return new Result<T>(true, null, BaseEnums.SUCCESS.code(), msg, data);
    }

    public static <T> Result successWithData(Integer code, String msg, T data) {
        return new Result<T>(true, null, code, msg, data);
    }

    //failure
    public static <T> Result failure() {
        return new Result<T>(false);
    }

    public static <T> Result failure(String msg) {
        return new Result<T>(false, BaseEnums.FAILURE.code(), msg);
    }

    public static <T> Result failure(Integer code, String msg) {
        return new Result<T>(false, code, msg);
    }

    public static <T> Result failureWithStatus(Integer status) {
        return new Result<T>(false, status, BaseEnums.FAILURE.code(), null);
    }

    public static <T> Result failureWithStatus(Integer status, String msg) {
        return new Result<T>(false, status, null, msg);
    }

    public static <T> Result failureWithData(T data) {
        return new Result<T>(false, null, null, BaseEnums.FAILURE.message(), data);
    }

    public static <T> Result failureWithData(T data, Integer code, String msg) {
        return new Result<T>(false, null, code, msg, data);
    }

    public static <T> Result paramError(String msg) {
        return new Result<T>(false, null, BaseEnums.PARAMETER_INVALID.code(), msg);
    }


}
