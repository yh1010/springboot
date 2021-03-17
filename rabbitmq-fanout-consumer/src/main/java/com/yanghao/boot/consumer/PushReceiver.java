package com.yanghao.boot.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author yanghao
 * @create 2020-03-16 14:45
 * @Description: push处理 消费者-接收者
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value="${mq.config.queue.push}",autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.FANOUT)
))
public class PushReceiver {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println("push接收处理：" + msg);
    }
}
