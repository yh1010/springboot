package com.yanghao.boot.configuration;

import org.springframework.context.annotation.Configuration;

/**
 * @author yanghao
 * @create 2020-03-21 17:14
 * @Description: 自定义配置类
 */
@Configuration
public class MyConfiguration {
    public MyConfiguration(){
        System.out.println("MyConfiguration容器启动初始化.....");
    }
}
