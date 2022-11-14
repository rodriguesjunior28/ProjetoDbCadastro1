package com.cadastro1.services;

import java.util.Optional;

import com.cadastro1.model.entity.Usuario;

public interface UsuarioService {

	Usuario autenticar (String email, String senha);  // aqui é um não CRUD
	
	Usuario salvarUsuario (Usuario usuario);          // aqui é CRUD
	
	void validarEmail (String email);                 // aqui o usuário só pode cadastrar 1 email por vez
	
	Optional<Usuario> buscarPorId(Long id);           // aqui é uma lista, se caso ele não encontrar nada ele volta vázio
}