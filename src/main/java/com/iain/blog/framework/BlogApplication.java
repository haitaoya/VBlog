package com.iain.blog.framework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.iain.blog"}
)
@MapperScan(
		basePackages = {"com.iain.blog.mapper"}
)
public class BlogApplication {

	public static void main(String[] args) {
//		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
		SpringApplication.run(BlogApplication.class, args);
	}

}
