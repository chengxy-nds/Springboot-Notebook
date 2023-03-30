package com.realtime.controller.polling;


import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 公众号：程序员小富
 * 设置异步线程池
 */
@Component
public class AsyncConfig implements WebMvcConfigurer {

    public static final long TIME_OUT = 10000L;

    @Bean
    public ThreadPoolTaskExecutor workerTaskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(25);
        executor.setQueueCapacity(100);
        return executor;
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer){
        configurer.setTaskExecutor(workerTaskExecutor());
        configurer.setDefaultTimeout(TIME_OUT);
    }
}
