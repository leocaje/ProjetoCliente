package com.br.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cliente.entity.Cliente;
import com.br.cliente.exception.ClienteNaoEncontradoException;
import com.br.cliente.repository.ClienteRepository;

import jakarta.validation.Valid;

@Service
public class ClienteService {
	// private final = constante. fica como constante porque o repositório não pode
	// ser alterado
	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) { // método construtor
		this.clienteRepository = clienteRepository;
	}

	/*
	 * método cadastra cliente diretamente no banco de dados H2
	 * 
	 * @Valid validação do cliente já está feita pela classe controller instância
	 * clienteRetorno do objeto Cliente que recebe o cliente salvo dentro do JPA
	 * Repository
	 * 
	 * passando o cliente como parâmetro para ser salvo no H2 retorna a variável
	 * clienteRetorno para que vá para o Repository
	 */
	public Cliente cadastrarCliente(@Valid Cliente cliente) {
		Cliente clienteRetorno = this.clienteRepository.save(cliente);
		return clienteRetorno;
	}

	public List<Cliente> retornarClientes() {
		// MÉTODO 1 - com variável
		List<Cliente> clientes = this.clienteRepository.findAll();
		return clientes;
	}

	// MÉTODO 2 - sem variável//return this.clienteRepository.findAll();}
	/*
	 * 
	 * Este método busca o cliente por id e lança uma exceção caso o id não esteja
	 * cadastrado ainda Puxa a mensagem de erro da classe
	 * ClienteNaoEncontradoException O método inclui um if para verificar se o id do
	 * cliente existe Caso não exista, o comando throw new vai buscar a mensagem de
	 * erro na classe
	 */
	public Cliente retornarClientePorId(Long id) throws ClienteNaoEncontradoException {
		if (this.clienteRepository.existsById(id)) {
			return this.clienteRepository.findById(id).get();
		}
		throw new ClienteNaoEncontradoException(id);
	}

	// public Cliente retornarClientePorCpf(String cpf) {
	// return this.clienteRepository.findByCpf(cpf);
	// }

	// public Cliente retornarClientePorNome(String nome) {
	// return this.clienteRepository.findByNome(nome);
	// }

	public MensagemDeSucesso deletarClientePorId(Long id) throws ClienteNaoEncontradoException {
		if (this.clienteRepository.existsById(id)) {
			this.clienteRepository.deleteById(id);
			MensagemDeSucesso mensagem = new MensagemDeSucesso();
			mensagem.setMensagem("Cliente deletado com sucesso!");
			return mensagem;
		}
		throw new ClienteNaoEncontradoException(id);
	}
}