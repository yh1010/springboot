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
 * @create 2020-03-18 22:39
 * @Description: 手机号校验注解
 */
@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface Phone {
    String message() default "请输入正确的电话号码";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List{
        Phone[] value();
    }
}
