package com.yanghao.boot.importSelector;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author yanghao
 * @create 2020-03-23 14:27
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import(UserImportSelector.class)
public @interface EnableUserConfig {
}
