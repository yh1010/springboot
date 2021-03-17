package com.yanghao.boot.exception;

import com.yanghao.boot.enums.ResultCode;
import lombok.Data;

/**
 * @author yanghao
 * @create 2020-03-18 14:58
 * @Description: 自定义全局异常
 */
@Data
public class BusinessException extends RuntimeException{

    protected Integer code;
    protected String message;

    public BusinessException(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }
}
