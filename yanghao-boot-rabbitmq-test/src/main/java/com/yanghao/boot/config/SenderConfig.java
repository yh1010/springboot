package com.yanghao.boot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanghao
 * @create 2020-03-13 18:29
 * @Description: mq的配置类
 */
@Configuration
public class SenderConfig {

    @Bean
    public Queue queue(){
        return new Queue("springboot-queue");
    }
}
