package com.yanghao.boot.async.controller;

import com.yanghao.boot.async.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanghao
 * @create 2020-03-17 1:51
 * @Description: 注册用户
 */
@RestController
public class AddUser {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/async")
    public String addUser(){
        this.scoreService.deleteScore();
        this.scoreService.addScore();
        return "ok";
    }

    @GetMapping("/asyncAndDelete")
    public String deleteUser(){
        this.scoreService.deleteScore();
        return "ok";
    }
}
