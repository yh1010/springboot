package com.yanghao.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanghao
 * @create 2020-03-05 23:39
 * @Description:
 */
@RestController
public class MsgController {

    @Value("${yanghao.msg}")
    private String msg;

    @GetMapping("/getMsg")
    public String outMsg(){ return msg; }
}
