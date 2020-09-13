package com.iain.springdemo.framework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

@SpringBootApplication(
		scanBasePackages = {"com.iain.springdemo"}
)
@MapperScan(
		basePackages = {"com.iain.springdemo.mapper"}
)
public class SpringdemoApplication {

	public static void main(String[] args) {
//		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
		SpringApplication.run(SpringdemoApplication.class, args);
	}

}
