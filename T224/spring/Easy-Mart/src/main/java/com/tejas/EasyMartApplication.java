package com.tejas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EasyMartApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyMartApplication.class, args);
	}

}
