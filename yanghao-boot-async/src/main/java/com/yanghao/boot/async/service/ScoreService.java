package com.yanghao.boot.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author yanghao
 * @create 2020-03-17 1:47
 * @Description: 注册用户送积分 -- 服务层
 */
@Slf4j
@Service
public class ScoreService {

    @Async
    public void addScore(){
        try {
            Thread.sleep(5000L);
            log.info("------处理积分------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async("scoreTaskExecutor")
    public void deleteScore(){
        try {
            Thread.sleep(5000L);
            log.info("------删除积分------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
