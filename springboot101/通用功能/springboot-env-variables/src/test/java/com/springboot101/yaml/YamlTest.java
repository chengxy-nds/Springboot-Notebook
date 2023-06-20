package com.springboot101.yaml;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.PropertyResolver;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class YamlTest {

    @Value("${env101.var11}")
    private String var11;

    @Test
    public void  myYamlTest() {
        log.info("Yaml 配置获取 {}", var11);
    }
}
