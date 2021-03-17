package com.yanghao.boot.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yanghao
 * @create 2020-03-18 22:22
 * @Description: 手机号码注解实现类
 */
public class PhoneValidator implements ConstraintValidator<Phone, String>{

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$"
    );

    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    /**
     * 校验的实现逻辑
     * @return
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null || s.length() == 0){
            return true;
        }
        Matcher matcher = PHONE_PATTERN.matcher(s);
        return matcher.matches();
    }
}
