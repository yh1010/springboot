package com.yanghao.boot.advice;

import com.yanghao.boot.response.ErrorResult;
import com.yanghao.boot.response.Result;
import com.yanghao.boot.utils.JsonUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author yanghao
 * @create 2020-03-17 17:45
 * @Description:
 */
@ControllerAdvice(basePackages = "com.yanghao.boot")
public class ResponseHandler implements ResponseBodyAdvice<Object>{
    /**
     * 是否支持advice功能
     *  true=支持，false=不支持
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * 处理response的具体业务方法
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(o instanceof ErrorResult){
            ErrorResult errorResult = (ErrorResult) o;
            return Result.fail(errorResult.getStatus(), errorResult.getMessage());
        }else if(o instanceof String){
            return JsonUtil.object2Json(Result.success(o));
        }
        return Result.success(o);
    }
}
