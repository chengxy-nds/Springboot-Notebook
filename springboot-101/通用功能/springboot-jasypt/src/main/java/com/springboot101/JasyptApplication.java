package com.springboot101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan("com.springboot101")
@SpringBootApplication
public class JasyptApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(JasyptApplication.class, args);
    }
}
