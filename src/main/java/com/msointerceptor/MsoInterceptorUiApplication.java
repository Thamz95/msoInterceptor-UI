package com.msointerceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.msointerceptor.repository")
@SpringBootApplication
@EnableJpaAuditing
public class MsoInterceptorUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsoInterceptorUiApplication.class, args);
	}
}
