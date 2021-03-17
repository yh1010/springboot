package com.yanghao.boot.enums;

/**
 * @author yanghao
 * @create 2020-03-17 16:48
 * @Description: 枚举类：状态码
 */
public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(0, "成功"),

    /* 系统500错误 */
    SYSTEM_ERROR(10000, "系统异常，稍后重试"),
    UNAUTHORIZED(10401, "签名验证失败"),

    /* 参数错误：10001 - 19999 */
    PARAM_IS_INVALID(10001, "参数无效"),

    /* 用户错误：20001-29999*/
    USER_HAS_EXISTED(20001, "用户名已存在"),
    USER_NOT_FIND(20002, "用户名不存在");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态码描述
     */
    private String message;

    ResultCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
