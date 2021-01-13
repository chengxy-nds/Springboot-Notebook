package com.xiaofu.attack;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.xiaofu.attack.mapper")
@SpringBootApplication
public class SpringbootSqlAttackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSqlAttackApplication.class, args);
	}

}
