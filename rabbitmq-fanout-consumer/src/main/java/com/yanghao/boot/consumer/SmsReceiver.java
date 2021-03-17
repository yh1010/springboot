package com.yanghao.boot.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author yanghao
 * @create 2020-03-16 14:45
 * @Description: sms接收处理 消费者-接收者
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value="${mq.config.queue.sms}",autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.FANOUT)
))
public class SmsReceiver {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println("sms接收处理：" + msg);
    }
}
