package com.springboot101.value注解;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class EnvVariables2Test {

    private final String var6;

    @Autowired
    EnvVariables2Test( @Value("${env101.var6}")  String var6) {

        this.var6 = var6;
    }


    /**
     * @value注解 final 获取
     */
    @Test
    public void var6Test() {
        log.info("final 注入: {}", var6);
    }

    /**
     * @value注解 非注册的类中使用
     * `@Component`、`@Service`、`@Controller`、`@Repository` 或 `@Configuration` 等**容器管理**注解的类中使用 @Value注解才会生效
     */
    @Test
    public void var7Test() {

//        log.info("非注册的类中使用 注入: {}", testService.getVar7());
    }
}
