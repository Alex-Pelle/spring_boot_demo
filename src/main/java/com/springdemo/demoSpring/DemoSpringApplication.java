package com.springdemo.demoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoSpringApplication.class, args);

	}

	@GetMapping("/bonjour")
	public String hello() {
		return String.format("Bonjour");
	}



}
