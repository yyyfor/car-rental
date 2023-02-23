package com.siming.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.siming.demo.mapper")
public class RentalCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalCarApplication.class, args);
	}

}
