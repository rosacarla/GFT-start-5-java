package dio.com.design.patterns.java.facade;

import dio.com.design.patterns.java.subsistema1.crm.CrmService;
import dio.com.design.patterns.java.subsistema2.cep.CepApi;

public class Facade {

    public void migrarCliente(String nome, String cep) {
        String cidade = CepApi.getInstancia().recuperarCidade(cep);
        String estado = CepApi.getInstancia().recuperarEstado(cep);

        CrmService.gravarCliente(nome, cep, cidade, estado);

    }
}
