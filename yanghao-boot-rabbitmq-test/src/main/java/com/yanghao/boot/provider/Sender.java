package com.yanghao.boot.provider;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yanghao
 * @create 2020-03-13 18:32
 * @Description: 生产者 发送者
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void send(){
        String msg = "生产者发送的信息是，当前时间为：" + System.currentTimeMillis();
        this.rabbitmqTemplate.convertAndSend("springboot-queue",msg);
    }
}



