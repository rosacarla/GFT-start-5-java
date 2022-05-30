package dio.com.design.patterns.spring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository  //anotacao opcional
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    //CrudRepository é uma strategy, interface que obriga seguir a estrategia de implementacao

}