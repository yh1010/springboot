package com.yanghao.boot.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yanghao
 * @create 2020-03-16 14:57
 * @Description: 用户服务生产者 - 发送者
 */
@Component
public class UserSender {

        @Autowired
        private AmqpTemplate rabbitmqTemplate;

        @Value("${mq.config.exchange}")
        private String exchange;


        public void send(){
                this.rabbitmqTemplate.convertAndSend(this.exchange,"user.log.debug","user.log.debug......");
                this.rabbitmqTemplate.convertAndSend(this.exchange,"user.log.info","user.log.info......");
                this.rabbitmqTemplate.convertAndSend(this.exchange,"user.log.warn","user.log.warn......");
                this.rabbitmqTemplate.convertAndSend(this.exchange,"user.log.error","user.log.error......");
        }
}
