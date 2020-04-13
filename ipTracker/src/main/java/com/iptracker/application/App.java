package com.iptracker.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.iptracker")
@EnableWebMvc
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
