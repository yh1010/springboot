package com.yanghao.boot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yanghao
 * @create 2020-03-13 18:40
 * @Description: 消费者 接收者
 */
@Component
public class Receiver {

    @RabbitListener(queues = "springboot-queue")
    public void receiver(String msg){
        System.out.println("消费者得到的消息是：" + msg);
    }
}

