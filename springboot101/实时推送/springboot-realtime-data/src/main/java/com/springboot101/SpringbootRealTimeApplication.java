package com.springboot101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableWebSocket
@EnableAsync
@SpringBootApplication
public class SpringbootRealTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRealTimeApplication.class, args);
	}
}
