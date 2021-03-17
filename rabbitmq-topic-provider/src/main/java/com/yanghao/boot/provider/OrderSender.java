package com.yanghao.boot.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yanghao
 * @create 2020-03-16 14:57
 * @Description: 订单服务生产者 - 发送者
 */
@Component
public class OrderSender {

        @Autowired
        private AmqpTemplate rabbitmqTemplate;

        @Value("${mq.config.exchange}")
        private String exchange;


        public void send(){
                this.rabbitmqTemplate.convertAndSend(this.exchange,"order.log.debug","order.log.debug......");
                this.rabbitmqTemplate.convertAndSend(this.exchange,"order.log.info","order.log.info......");
                this.rabbitmqTemplate.convertAndSend(this.exchange,"order.log.warn","order.log.warn......");
                this.rabbitmqTemplate.convertAndSend(this.exchange,"order.log.error","order.log.error......");
        }
}
