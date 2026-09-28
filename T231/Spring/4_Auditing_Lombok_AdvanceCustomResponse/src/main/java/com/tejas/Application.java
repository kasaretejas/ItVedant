package com.tejas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.tejas.entities.Student;

@SpringBootApplication
@EnableJpaAuditing   //for auditing step 3
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
//		Student student = new Student();
//		student.getName();
	}

}
