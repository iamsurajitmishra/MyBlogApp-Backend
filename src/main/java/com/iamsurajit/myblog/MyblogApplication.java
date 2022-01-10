package com.iamsurajit.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
    @SpringBootApplication - enables
    1. Auto Configuration
    2. Component Scanning
    3. Additional configuration
 */
@SpringBootApplication
public class MyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}

}
