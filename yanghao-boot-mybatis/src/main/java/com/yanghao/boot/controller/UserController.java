package com.yanghao.boot.controller;

import com.yanghao.boot.entity.User;
import com.yanghao.boot.service.UserService;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author yanghao
 * @create 2020-03-19 22:46
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 初始化数据
     */
    @GetMapping(value = "/initUser")
    public void initUser(){
        for (int i = 0; i < 1000; i++){
            User user = new User();
            String temp = "user" + i;
            Random random = new Random();
            int sex = random.nextInt(2);
            user.setSex((byte) sex);
            user.setUsername(temp);
            user.setPassword(temp);
            this.userService.saveUser(user);
        }
    }
}
