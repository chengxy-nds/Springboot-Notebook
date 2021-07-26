package com.xiaofu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.xiaofu")
@SpringBootApplication
public class JasyptApplication {

	public static void main(String[] args) {
		SpringApplication.run(JasyptApplication.class, args);
	}
}
