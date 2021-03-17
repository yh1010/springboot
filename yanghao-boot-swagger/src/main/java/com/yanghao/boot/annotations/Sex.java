package com.yanghao.boot.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author yanghao
 * @create 2020-03-18 23:02
 * @Description: 定义性别校验注解
 */
@Documented
@Constraint(validatedBy = SexValidator.class)
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface Sex {

    String message() default "输入的性别格式错误";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List{
        Sex[] value();
    }
}
