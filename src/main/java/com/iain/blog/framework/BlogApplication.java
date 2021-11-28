package com.iain.blog.framework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(
		scanBasePackages = {"com.iain.blog"}
)
@MapperScan(
		basePackages = {"com.iain.blog.mapper"}
)
@EnableAsync
public class BlogApplication {

	public static void main(String[] args) {
//		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
		SpringApplication.run(BlogApplication.class, args);
	}

}
