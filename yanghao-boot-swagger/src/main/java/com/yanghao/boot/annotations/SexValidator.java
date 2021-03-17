package com.yanghao.boot.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yanghao
 * @create 2020-03-18 23:03
 * @Description: 性别注解实现类
 */
public class SexValidator implements ConstraintValidator<Sex, Byte> {

    private static final Pattern SEX_PATTERN = Pattern.compile(
            "^[0|1]{1}$"
    );

    @Override
    public void initialize(Sex constraintAnnotation) {

    }

    @Override
    public boolean isValid(Byte aByte, ConstraintValidatorContext constraintValidatorContext) {
            if (aByte == null || aByte == 0){
                return true;
            }
            Matcher matcher = SEX_PATTERN.matcher(aByte.toString());
            return matcher.matches();
        }
}
