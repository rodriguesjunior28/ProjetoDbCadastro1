package com.cadastro1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastro1.model.entity.Usuario;

@Repository  // é a primeira coisa a ser feita                    // Long é referência ao Id  
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	//query methods é como é chamado esse metódo abaixo
	boolean existsByEmail(String email); 

	//query methods ele vaii trazer uma lista com os emails
	Optional<Usuario> findByEmail(String email);

}