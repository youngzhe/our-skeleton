package com.our.common.base;


import java.util.HashMap;
import java.util.Map;

public enum BaseEnums implements BaseEnum<Integer, String> {

    SUCCESS(200, "request success"),
    FAILURE(9999, "request failure"),
    NOT_FOUND(4001, "resource not found"),
    FORBIDDEN(4002, "forbidden access"),
    VERSION_NOT_MATCH(4003, "record is not exist or version not match"),
    REPEATED_OPERATION(4004, "repeated operation"),
    DATA_AGGREGATE_FAILURE(4005, "data aggregate failure"),
    PARAMETER_NOT_NULL(2001, "parameter cannot be null"),
    PARAMETER_INVALID(2002, "parameter invalid"),
    UNAUTHORIZED(3000,"unauthorized"),//未认证（签名错误）
    NOT_AGREE(3001,"not agree"),//未签署最新版本用户协议
    NOT_REGISTERED_DEVICE(3001,"not registered device"),//拒绝执行（未注册的设备发送了设备注册之外的请求）
    URL_NOT_FOUND(3002,"url not found"),//接口不存在
    INTERNAL_SERVER_ERROR(3003,"internal server error"),//服务器内部错误
    LOGIN_FAIL(3004,"login failure"),//登录失败
    RETRY_FAIL(3005,"retry failure"),//密码错误次数超过限制
    LOGIN_IP_EXCEPTION(3006,"ip exception"),//IP异常
    LOGIN_KICKOUT(3007,"login"),//账户被踢出
    LOGIN_MSG_MAX_COUNT(3008,"login msg max count"),//短信超出10条限制
    PHONE_MODIFIED(3009,"phone modified"),//手机号修改成功
    PHONE_MODIFY_FAIL(3010,"phone modify fail"),//手机号修改失败
    RESOURCE_EXIST(3011,"resource exist already"),//资源已存在
    RESOURCE_IN_USE(3012,"resource is in use");//资源在使用中

    private static Map<Integer, String> allMap = new HashMap<Integer, String>();
    private Integer code;
    private String message;

    BaseEnums(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    static {
        for (BaseEnums baseEnums:BaseEnums.values()) {
            allMap.put(baseEnums.code, baseEnums.message);
        }
    }

    @Override
    public Integer code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }

    public String message(String code){
        return allMap.get(code);
    }
}
