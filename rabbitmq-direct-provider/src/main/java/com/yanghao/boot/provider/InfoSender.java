package com.yanghao.boot.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yanghao
 * @create 2020-03-16 14:57
 * @Description: info日志生产者 - 发送者
 */
@Component
public class InfoSender {

        @Autowired
        private AmqpTemplate rabbitmqTemplate;
        @Value("${mq.config.exchange}")
        private String exchange;
        @Value("${mq.config.queue.info.routing.key}")
        private String infoRoutKey;
        @Value("${mq.config.queue.error.routing.key}")
        private String errorRoutKey;

        public void send(){
            String msg = "当前时间为：" + System.currentTimeMillis();
            this.rabbitmqTemplate.convertAndSend(this.exchange,this.infoRoutKey,msg);
        }
}
