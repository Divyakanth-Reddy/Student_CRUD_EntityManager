package com.example.crudentityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// Since this is a small application with all the components,entities in the same package, we can skip using below annotations.
//@ComponentScan(basePackages = "com.*")
//@EntityScan("com.example.crudentityManager")
public class CrudentityManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudentityManagerApplication.class, args);
	}

}
