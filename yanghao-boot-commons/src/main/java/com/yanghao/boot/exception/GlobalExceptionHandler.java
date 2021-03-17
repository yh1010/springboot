package com.yanghao.boot.exception;

import com.yanghao.boot.enums.ResultCode;
import com.yanghao.boot.response.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yanghao
 * @create 2020-03-17 21:37
 * @Description: 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理时运行异常
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public ErrorResult handleThrowable(BusinessException throwable, HttpServletRequest request){
        ErrorResult errorResult = ErrorResult.builder().status(throwable.code)
                .message(throwable.message)
                .exception(throwable.getClass().getName())
                .build();
        log.error("URL:{},系统异常：",request.getRequestURI(),errorResult);
        return errorResult;
    }

    /**
     * validator 统一异常封装
     * @param m
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException m, HttpServletRequest request){
        String msg = this.handle(m.getBindingResult().getFieldErrors());
        ErrorResult errorResult = ErrorResult.fail(ResultCode.PARAM_IS_INVALID, m, msg);
        log.warn("URL:{}, 参数校验异常：{}", request.getRequestURI(), msg);
        return errorResult;
    }

    private String handle(List<FieldError> list){
        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError:list){
            builder.append(fieldError.getField());
            builder.append("=[");
            builder.append(fieldError.getDefaultMessage());
            builder.append("] ");
        }
        return builder.toString();
    }

    /**
     * Assert 统一异常封装
     * @param e
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalArgumentException(IllegalArgumentException e, HttpServletRequest request){
        ErrorResult errorResult = ErrorResult.builder().status(4000)
                .message(e.getMessage())
                .exception(e.getClass().getName())
                .build();
        log.warn("URL:{}, 业务校验异常：{}", request.getRequestURI(), e);
        return errorResult;
    }
}
