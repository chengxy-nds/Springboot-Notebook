package com.xiaofu;

import com.xiaofu.process.MyPropertiesBeanFactoryPostProcessor;
import com.xiaofu.process.conf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import({MyPropertiesBeanFactoryPostProcessor.class, conf.class})
@ComponentScan("com.xiaofu")
@SpringBootApplication
public class JasyptApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(JasyptApplication.class, args);
    }
}
