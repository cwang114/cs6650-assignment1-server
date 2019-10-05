package com.lion.skiresortbackend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkiResortBackendApplication {
	
	public static final Logger logger = LogManager.getLogger(SkiResortBackendApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SkiResortBackendApplication.class, args);
	}

}
