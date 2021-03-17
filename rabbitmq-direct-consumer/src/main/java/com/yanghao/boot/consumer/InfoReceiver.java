package com.yanghao.boot.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author yanghao
 * @create 2020-03-16 14:45
 * @Description: Info日志消费者-接收者
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value="${mq.config.queue.info}",autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.DIRECT),
        key = "${mq.config.queue.info.routing.key}"
))
public class InfoReceiver {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println("接收到的Info日志：" + msg);
    }
}
