package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import service.CommandService;
import service.PersonService;
import service.PetService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "service", "command"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CommandService commandService) {
		return args -> {
			commandService.startCommandLoop();
		};
	}

	@Bean
	public PersonService personService() {
		return new PersonService();
	}

	@Bean
	public PetService petService() {
		return new PetService();
	}
}