package com.springboot101.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 公众号：程序员小富
 * @Description:
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redisson() {
        return Redisson.create();
    }
}
