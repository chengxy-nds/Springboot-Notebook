package com.springboot101.value注解;

import com.springboot101.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class EnvVariables3Test {

    /**
     * @value注解 引用方式不对
     */
    @Test
    public void var7_1Test() {

        TestService testService = new TestService();
        log.info("引用方式不对 注入: {}", testService.getVar7());
    }
}
