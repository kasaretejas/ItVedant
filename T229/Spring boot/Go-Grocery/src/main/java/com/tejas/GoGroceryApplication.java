package com.tejas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GoGroceryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoGroceryApplication.class, args);
	}

}
