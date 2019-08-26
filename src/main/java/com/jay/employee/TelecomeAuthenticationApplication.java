package com.jay.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TelecomeAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelecomeAuthenticationApplication.class, args);
	}

}
