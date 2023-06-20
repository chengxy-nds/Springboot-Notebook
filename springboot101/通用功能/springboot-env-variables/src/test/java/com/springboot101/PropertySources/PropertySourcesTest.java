package com.springboot101.PropertySources;

import com.alibaba.fastjson.JSON;
import com.springboot101.configurationProperties.MyConf;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class PropertySourcesTest {

    @Resource
    private PropertySourcesConf propertySourcesConf;

    @Resource
    private PropertySourcesConf2 propertySourcesConf2;

    @Resource
    private Environment environment;

    @Test
    public void myConfTest() {
        log.info("@PropertySources注解 @Value 获取 {}", propertySourcesConf.getVar9());
        log.info("@PropertySources注解 environment 获取 {}", propertySourcesConf.getVar10());
    }


    @Test
    public void myConfTest2() {
        log.info("@PropertySources注解 @Value 获取 {}", propertySourcesConf2.getVar9());
        log.info("@PropertySources注解 environment 获取 {}", propertySourcesConf2.getVar10());
    }
}
