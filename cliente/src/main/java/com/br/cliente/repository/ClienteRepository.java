package com.br.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cliente.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByCpf(String cpf);
	Cliente findByNome(String nome);
}
