package com.cadastro1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro1.model.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}