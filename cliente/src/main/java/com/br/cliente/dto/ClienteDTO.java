package com.br.cliente.dto;

import com.br.cliente.entity.Cliente;

public class ClienteDTO {
	
	private String nome;
	private Integer idade;
	private String sx;
	
	
	public static ClienteDTO retornaCliente(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO(cliente.getNome(), cliente.getIdade(), cliente.getSx());
		return clienteDTO;
	}
	
	public static Cliente retornaCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO.nome, clienteDTO.getIdade(), clienteDTO.sx);
		return cliente;
	}
	public ClienteDTO() {
		
	}
	public ClienteDTO(String nome, Integer idade, String sx) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sx = sx;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
