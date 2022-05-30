package dio.com.design.patterns.spring.service.impl;

import java.util.Optional;

import dio.com.design.patterns.spring.model.Cliente;
import dio.com.design.patterns.spring.service.ClienteService;
import dio.com.design.patterns.spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.com.design.patterns.spring.model.ClienteRepository;
import dio.com.design.patterns.spring.model.Endereco;
import dio.com.design.patterns.spring.model.EnderecoRepository;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, que pode ser injetada
 * pelo Spring (via {@link Autowired}). Como essa classe é um {@link Service},
 * será tratada como um <b>Singleton</b>.
 * 
 * @author rosacarla
 */

@Service
public class ClienteServiceImpl implements ClienteService {

	// Singleton: injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Cliente> buscarTodos() {  //Buscar todos os Clientes
		return clienteRepository.findAll();  //entende como uma lista
	}

	@Override
	public Cliente buscarPorId(Long id) {  //Buscar Cliente por ID
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {   //Buscar Cliente por ID, caso exista
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {   //se cliente existir
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {  //Deletar Cliente por ID
		clienteRepository.deleteById(id);
	}

	private void salvarClienteComCep(Cliente cliente) { //Verificar se o Endereco do Cliente já existe (pelo CEP)
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);  //Inserir Cliente, vinculando o Endereco (novo ou existente)
		clienteRepository.save(cliente);
	}

}
