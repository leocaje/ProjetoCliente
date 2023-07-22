package com.br.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.cliente.entity.Cliente;
import com.br.cliente.exception.ClienteNaoEncontradoException;
import com.br.cliente.service.ClienteService;
import com.br.cliente.service.MensagemDeSucesso;

import jakarta.validation.Valid;

//esta classe vai servir para realizar controle do CRUD do cliente
@RestController
@RequestMapping("/api/v1/clientes/cliente")
public class ClienteController {

	private ClienteService clienteService; // instaciando o objeto (visibilidade Objeto instancia)

	@Autowired // anotação de acoplamento com ClienteService
	public ClienteController(ClienteService clienteService) { // Construtor do controller para o objeto cliente
		this.clienteService = clienteService;
	}

	// CRUD

	@PostMapping // Post -> Create
	@ResponseStatus(HttpStatus.CREATED) // checa o status HTTP, averiguando o Repository
	public Cliente cadastrarCliente(@Valid @RequestBody Cliente cliente) {
		Cliente clienteSalvo = this.clienteService.cadastrarCliente(cliente);
		return clienteSalvo;
	}
	/*
	 * método para criar o objeto cliente
	 * 
	 * @Valid anotação para validar o objeto
	 * 
	 * @RequestBody faz a requisição de todo o corpo do objeto cliente
	 * 
	 * Cliente objeto, clienteSalvo instância que recebe a instância clienteService
	 * que pega o método cadastrarCliente que tem como parâmetro todo o corpo do
	 * cliente esse método precisa retornar um clienteSalvo para mostrar no status
	 * HTTP se foi ou não cadastrado um cliente
	 */

	@GetMapping
	public List<Cliente> retornarClientes() {
		// MÉTODO 1
		List<Cliente> clientes = this.clienteService.retornarClientes();
		return clientes;

		// MÉTODO 2
		// return this.clienteService.retornarClientes();
	}

	@GetMapping("/{id}") // endpoint dentro de {} indica uma variável
	public Cliente retornarClientePorId(@PathVariable Long id) throws ClienteNaoEncontradoException {
		// MÉTODO 1
		Cliente cliente = this.clienteService.retornarClientePorId(id);
		return cliente;
	}
	// MÉTODO 2//return this.clienteService.retornarClientePorId(id);}
	// @GetMapping("/{cpf}")
	// public Cliente retornarClientePorCpf(@PathVariable String cpf) {
	// MÉTODO 1
	// Cliente cliente = this.clienteService.retornarClientePorCpf(cpf);
	// return cliente;

	// MÉTODO 2
	// return this.clienteService.retornarClientePorCpf(cpf);
	// }

	// @GetMapping("/{nome}")
	// public Cliente retornarClientePorNome(@PathVariable String nome) {
	// MÉTODO 1
	// Cliente cliente = this.clienteService.retornarClientePorNome(nome);
	// return cliente;

	// MÉTODO 2
	// return this.clienteService.retornarClientePorNome(nome);
	// }

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public MensagemDeSucesso deletarClientePorId(@PathVariable Long id) throws ClienteNaoEncontradoException {
		return this.clienteService.deletarClientePorId(id);
	}
}
