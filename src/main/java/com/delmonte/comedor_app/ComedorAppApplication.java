package com.delmonte.comedor_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.delmonte.comedor_app.controllers", "com.delmonte.comedor_app.services"})
public class ComedorAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(ComedorAppApplication.class, args);
	}
}