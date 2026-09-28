package com.tejas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.tejas.entities.Laptop;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) 
	{
		SpringApplication.run(Application.class, args);
		//testing getters and setters created by lombok
		//Laptop laptop = new Laptop();
		//laptop.getBrand();
		//laptop.setBrand(null);
	}

}
