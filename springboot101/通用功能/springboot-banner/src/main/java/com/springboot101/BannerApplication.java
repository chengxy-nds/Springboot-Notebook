package com.springboot101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class BannerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BannerApplication.class, args);
    }
}
