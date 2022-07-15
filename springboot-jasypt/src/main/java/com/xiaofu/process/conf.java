package com.xiaofu.process;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Auther: 公众号：程序员小富
 * @Date: 2021/7/30 18:41
 * @Description:
 */
@Configuration
public class conf {

    @Bean
    public EnvCopy1 envCopy1(final ConfigurableEnvironment environment) {
        return new EnvCopy1(environment);
    }
}
