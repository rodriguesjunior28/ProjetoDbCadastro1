package com.cadastro1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // aqui é a primeira coisa a ser feita
public class UsuarioController {
	
	@GetMapping("/user")
	public String helloWorld() {
		return "Junior";
	}

	
}