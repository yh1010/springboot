package com.yanghao.boot.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yanghao
 * @create 2020-03-16 14:57
 * @Description: 商品服务生产者 - 发送者
 */
@Component
public class ProductSender {

        @Autowired
        private AmqpTemplate rabbitmqTemplate;

        @Value("${mq.config.exchange}")
        private String exchange;


        public void send(){
                this.rabbitmqTemplate.convertAndSend(this.exchange,"product.log.debug","product.log.debug......");
                this.rabbitmqTemplate.convertAndSend(this.exchange,"product.log.info","product.log.info......");
                this.rabbitmqTemplate.convertAndSend(this.exchange,"product.log.warn","product.log.warn......");
                this.rabbitmqTemplate.convertAndSend(this.exchange,"product.log.error","product.log.error......");
        }
}
