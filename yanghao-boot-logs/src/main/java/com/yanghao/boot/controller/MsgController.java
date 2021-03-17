package com.yanghao.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgController.class);

    @Value("${yanghao.msg}")
    private String msg;

    @GetMapping("/getMsg")
    public String outMsg(){ return msg; }

    @GetMapping("/getLog")
    public void log(){
        LOGGER.trace("--------trace---------");
        LOGGER.debug("--------debug---------");
        LOGGER.info("--------info---------");
        LOGGER.warn("--------warn---------");
        LOGGER.error("--------error---------");
    }

}
