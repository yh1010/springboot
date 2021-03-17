package com.yanghao.boot.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yanghao
 * @create 2020-03-21 17:16
 * @Description: 测试类
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserService.class);
        UserBean user = (UserBean) context.getBean("findUser");
        System.out.println(user.toString());
    }
}
