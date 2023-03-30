package com.xiaofu.erupt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import xyz.erupt.core.annotation.EruptScan;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
@ComponentScan({"xyz.erupt", "com.xiaofu.erupt.model"}) // ↓ xyz.erupt必须有
@EntityScan({"xyz.erupt", "com.xiaofu.erupt.model"})    // ↓ 如果包名com.example.demo有变化
@EruptScan({"xyz.erupt", "com.xiaofu.erupt.model"})     // → 要修改为变化后的包名
public class SpringBootEruptApplication {

    public static void main(String[] args) throws URISyntaxException, IOException {
        SpringApplication.run(SpringBootEruptApplication.class, args);
        System.setProperty("java.awt.headless", "false");
    }
}
