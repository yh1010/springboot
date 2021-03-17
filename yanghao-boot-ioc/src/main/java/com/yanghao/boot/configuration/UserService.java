package com.yanghao.boot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanghao
 * @create 2020-03-21 18:00
 * @Description:
 */
@Configuration
public class UserService {

    @Bean
    public UserBean findUser(){
        UserBean userBean= new UserBean();
        userBean.setUsername("agan");
        userBean.setPassword("123456");
        return userBean;
    }
}
