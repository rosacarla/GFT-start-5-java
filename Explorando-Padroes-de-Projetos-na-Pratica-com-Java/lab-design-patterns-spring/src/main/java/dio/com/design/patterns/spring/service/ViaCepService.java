package dio.com.design.patterns.spring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dio.com.design.patterns.spring.model.Endereco;

/**
 * Client HTTP, criado via <b>OpenFeign</b>, pra consumo da API do <b>ViaCEP</b>
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 * @author rosacarla
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

	@GetMapping("/{cep}/json/") //conversao do json no objeto mapeado
	Endereco consultarCep(@PathVariable("cep") String cep);
}
