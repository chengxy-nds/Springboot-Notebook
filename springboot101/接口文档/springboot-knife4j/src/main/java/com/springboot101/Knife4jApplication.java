package com.springboot101;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableKnife4j
@SpringBootApplication
public class Knife4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(Knife4jApplication.class, args);
    }
}
