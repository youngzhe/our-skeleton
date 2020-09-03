package com.our.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 结果返回类
 * @ClassName Result
 */
@Data
@ApiModel(value = "返回类")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 397032924074207632L;
    @ApiModelProperty(value = "请求是否成功")
    private boolean success = true;
    @ApiModelProperty(value = "状态码")
    private Integer status;
    @ApiModelProperty(value = "code")
    private Integer code;
    @ApiModelProperty(value = "描述")
    private String message;
    @ApiModelProperty(value = "数据")
    private T data;

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }
    public Result(){}

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, Integer code) {
        this.success = success;
        this.code = code;
    }

    public Result(boolean success, Integer  code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Result(boolean success, Integer status, Integer code, String message) {
        this.success = success;
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public Result(boolean success, Integer status, Integer code, String message, T data) {
        this.success = success;
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
