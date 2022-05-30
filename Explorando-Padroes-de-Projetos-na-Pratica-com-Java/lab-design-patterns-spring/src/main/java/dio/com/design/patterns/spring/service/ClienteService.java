package dio.com.design.patterns.spring.service;

import dio.com.design.patterns.spring.model.Cliente;

/**
 * Interface define o padrão <b>Strategy</b> no domínio de cliente.
 * Se necessário, pode ter multiplas implementações da mesma interface.
 * @author rosacarla
 */

//interface possui as operacoes de CRUD
public interface ClienteService {

	Iterable<Cliente> buscarTodos();

	Cliente buscarPorId(Long id);

	void inserir(Cliente cliente);

	void atualizar(Long id, Cliente cliente);

	void deletar(Long id);

}
