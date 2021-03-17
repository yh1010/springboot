package com.yanghao.boot.importSelector;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yanghao
 * @create 2020-03-23 14:29
 * @Description:
 */
public class Mains {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        RoleBean roleBean = context.getBean(RoleBean.class);
        UsersBean usersBean = context.getBean(UsersBean.class);
        System.out.println(roleBean.toString());
        System.out.println(usersBean.toString());
    }
}

