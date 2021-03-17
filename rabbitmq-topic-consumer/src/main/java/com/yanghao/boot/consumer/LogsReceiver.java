package com.yanghao.boot.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author yanghao
 * @create 2020-03-16 16:45
 * @Description: logs日志消费者 - 接收者
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${mq.config.queue.logs}",autoDelete = "true"),
        exchange =@Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.TOPIC),
        key = "*.log.*"
))
public class LogsReceiver {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println("all-----------------日志" + msg);
    }
}
