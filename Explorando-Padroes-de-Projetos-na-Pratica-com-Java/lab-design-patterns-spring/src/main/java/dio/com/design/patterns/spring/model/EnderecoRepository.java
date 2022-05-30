package dio.com.design.patterns.spring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository  //anotacao opcional
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}