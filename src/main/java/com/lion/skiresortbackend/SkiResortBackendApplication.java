package com.lion.skiresortbackend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.lion.skiresortbackend.repository")
public class SkiResortBackendApplication {
	
	public static final Logger logger = LogManager.getLogger(SkiResortBackendApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SkiResortBackendApplication.class, args);
	}

}
