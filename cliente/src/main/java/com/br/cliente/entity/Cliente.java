package com.br.cliente.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nome não pode ser nulo")
	private String nome;
	@NotEmpty(message = "CPF não pode ser nulo")
	private String cpf;
	private Integer idade;
	@NotEmpty(message = "Sexo não pode ser nulo")
	private String sx;
	
	public Cliente(String nome, String cpf, Integer idade, String sx) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.sx = sx;
	}
	public Cliente(String nome, Integer idade,String sx) {
		this.nome = nome;
		this.idade = idade;
		this.sx = sx;
		
	}
	public Cliente() {
		
		
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSx() {
		return sx;
	}

	public void setSx(String sx) {
		this.sx = sx;
	}
	
}
