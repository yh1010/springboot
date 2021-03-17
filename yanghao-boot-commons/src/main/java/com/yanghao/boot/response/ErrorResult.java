package com.yanghao.boot.response;

import com.yanghao.boot.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanghao
 * @create 2020-03-17 17:51
 * @Description: 错误结果集
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResult {

    /**
     * 异常状态码
     */
    private Integer status;
    /**
     * 用户看的见的异常，例如：用户名重复
     */
    private String message;
    /**
     * 异常名称
     */
    private String exception;

    /**
     * 对异常枚举进行封装
     * @param resultCode
     * @param throwable
     * @return
     */
    public static ErrorResult fail(ResultCode resultCode, Throwable throwable){
        ErrorResult errorResult = new ErrorResult();
        errorResult.setStatus(resultCode.getCode());
        errorResult.setMessage(resultCode.getMessage());
        errorResult.setException(throwable.getClass().getName());
        return errorResult;
    }

    /**
     * 对异常提示语进行封装
     * @param resultCode
     * @param throwable
     * @param message
     * @return
     */
    public static ErrorResult fail(ResultCode resultCode, Throwable throwable, String message){
        ErrorResult errorResult = ErrorResult.fail(resultCode,throwable);
        errorResult.setMessage(message);
        return errorResult;
    }
}
