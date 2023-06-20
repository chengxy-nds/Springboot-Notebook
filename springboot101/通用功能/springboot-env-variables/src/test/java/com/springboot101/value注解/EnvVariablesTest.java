package com.springboot101.value注解;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class EnvVariablesTest {

    @Value("${env101.var1}")
    private String var1;

    private static String var3;

    private static String var4;


    @Value("${env101.var3}")
    public void setVar3(String var3) {
        EnvVariablesTest.var3 = var3;
    }

    private final String var6;

    @Autowired
    EnvVariablesTest(@Value("${env101.var4}") String var4,@Qualifier("var6") String var6) {
        EnvVariablesTest.var4 = var4;

        this.var6 = var6;
    }

    public static String getVar4() {
        return var4;
    }

    public static String getVar3() {
        return var3;
    }

    /**
     * @value注解 普通获取
     */
    @Test
    public void var1Test() {
        log.info("配置文件属性: {}", var1);
    }

    /**
     * @value注解 静态变量获取
     */
    @Test
    public void var2Test() {
        log.info("普通方法注入：{}", var3);
        log.info("构造函数注入：{}", var4);
    }

    /**
     *
     */
    @Test
    public void var3Test() {
        log.info("静态变量注入：{}", var3);
        log.info("静态变量注入：{}", var4);
        log.info("final 注入：{}", var6);
    }

    /**
     *
     */
    @Test
    public void var4Test() {
        log.info(var1);
    }


    /**
     *
     */
    @Test
    public void var5Test() {
        log.info(var1);
    }

    /**
     * 第六种方式
     */
    @Test
    public void var6Test() {
        log.info(var1);
    }

    /**
     * 第七种方式
     */
    @Test
    public void var7Test() {
        log.info(var1);
    }

    /**
     * 第八种方式
     */
    @Test
    public void var8Test() {
        log.info(var1);
    }

    /**
     * 第九种方式
     */
    @Test
    public void var9Test() {
        log.info(var1);
    }
}
