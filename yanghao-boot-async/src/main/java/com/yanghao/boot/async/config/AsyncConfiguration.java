package com.yanghao.boot.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yanghao
 * @create 2020-03-17 1:46
 * @Description: 异步配置类
 */
@Configuration
@EnableAsync
public class AsyncConfiguration {

    @Bean(name = "scoreTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //核心线程数
        taskExecutor.setCorePoolSize(10);
        //线程池维护线程的线程最大数量，只有在缓冲队列满了才会申请超过核心线程数的线程
        taskExecutor.setMaxPoolSize(100);
        //设置缓存队列能够容纳的线程数
        taskExecutor.setQueueCapacity(50);
        //设置超过核心线程以外的线程的存活时间：200秒
        taskExecutor.setKeepAliveSeconds(200);
        //异步方法内部线程名称
        taskExecutor.setThreadNamePrefix("score-");
        /**
         * 当线程池的任务缓冲队列已满并且线程池中的线程数目达到MaxmumPoolSize，如果还有任务到来就会采取任务拒绝策略
         * 通常有以下四种策略：
         * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionExecption异常
         * ThreadPoolExecutor.DiscardPolicy:也是丢弃任务，但是不抛出异常
         * ThreadPoolExecutor.DiscardOldestPolicy:丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
         * ThreadPoolExecutor.CallerRunsPolicy:重新添加当前任务，自动重复调用 execute（）方法，直到成功
         */
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }
}
