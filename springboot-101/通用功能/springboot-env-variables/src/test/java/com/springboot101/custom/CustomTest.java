package com.springboot101.custom;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;

import javax.annotation.Resource;
import java.util.Arrays;

@Slf4j
@SpringBootTest
public class CustomTest {

    @Autowired
    private PropertySources propertySources;

    @Test
    public void customTest() {
        for (PropertySource<?> propertySource : propertySources) {
            log.info("自定义获取 配置获取 name {} ,{}", propertySource.getName(), propertySource.getSource());
        }
    }
}
