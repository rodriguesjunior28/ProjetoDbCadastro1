package com.cadastro1.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// aqui é um mapeamento
@EntityScan(basePackages = {"com.cadastro1.model.entity"})
@EnableJpaRepositories(basePackages = {"com.cadastro1.repositories"})
@ComponentScan(basePackages = {"com.cadastro1.controller", "com.cadastro1.service", 
		"com.cadastro1.service.impl"})
// daqui pra cima é o mapeamento
@SpringBootApplication
public class ProjetoRecodeFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoRecodeFinalApplication.class, args);
	}

}
