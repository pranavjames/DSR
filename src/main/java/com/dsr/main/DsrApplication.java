package com.dsr.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.dsr.model")
@EnableJpaRepositories(basePackages = "com.dsr.repo")
@SpringBootApplication(scanBasePackages = "com.dsr")
public class DsrApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsrApplication.class, args);
	}

}
