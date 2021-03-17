package com.yanghao.boot.response;

import com.yanghao.boot.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanghao
 * @create 2020-03-17 16:43
 * @Description: 返回的结果集
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {

    /**
     * 1.status状态值：代表本次请求response的状态结果
     */
    private Integer status;
    /**
     * response描述：对本次状态码的描述
     */
    private String message;
    /**
     * data数据：本次返回的数据
     */
    private T data;

    /**
     * 把ResultCode枚举转换为Result
     * @param resultCode
     */
    private void setResultCode(ResultCode resultCode){
        this.status = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    /**
     * 成功，创建Result：没有data数据
     * @return
     */
    public static Result success(){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    /**
     * 成功，创建Result：有data数据
     * @param data
     * @return
     */
    public static Result success(Object data){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 失败，指定status、message
     * @param status
     * @param message
     * @return
     */
    public static Result fail(int status, String message){
        Result result = new Result();
        result.setStatus(status);
        result.setMessage(message);
        return result;
    }

    /**
     * 失败，指定resultCode枚举
     * @param resultCode
     * @return
     */
    public static Result fail(ResultCode resultCode){
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

}
