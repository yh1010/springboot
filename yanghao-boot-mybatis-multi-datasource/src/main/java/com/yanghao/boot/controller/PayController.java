package com.yanghao.boot.controller;

import com.yanghao.boot.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanghao
 * @create 2020-03-20 1:25
 * @Description:
 */
@RestController
public class PayController {

    @Autowired
    private PayService payService;

    @GetMapping(value = "/pay")
    public void pay(){
        this.payService.pay(1, 2, 10);
    }
}
