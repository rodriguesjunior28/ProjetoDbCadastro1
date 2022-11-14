package com.cadastro1.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cadastro1.model.enums.StatusUsuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data                   // ele cria os gets e sets 
@NoArgsConstructor      // aqui é vázio a espera de algo 
@AllArgsConstructor     // aqui com todas a propriedades dentro do construtor que estão abaixo
@Builder                // ele já faz as instâncias automaticamente ex: Usuario ussuario = new Usuario();
public class Usuario {
	
	@Id  // ao colocar o Id ele faz tudo que é preciso pra referente a parametro 
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // pode ser IDENTITY ou AUTO
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private Integer cpf;
	
	@Column (name = "stats")              // aqui tá stats pelo banco já ter status como nome reservado a ele
	@Enumerated(value = EnumType.STRING)  // aqui pelo fato da opção de escolha
	private StatusUsuario genero;         // só importar o enums depoois configurar
	
	@Column 
	private String senha;  
}
