package com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.rest_endpoints.contracts.input.mappers;

import com.vinicius123131.entidades.Pessoa;
import com.vinicius123131.entidades.factories.PessoaFactory;
import com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.rest_endpoints.contracts.input.CriarNovaPessoaRestEndpointInput;
import org.springframework.stereotype.Component;

@Component
public class CriarNovaPessoaRestEndpointInputMapper {

    public Pessoa map(CriarNovaPessoaRestEndpointInput restEndpoint){
        var pessoa = new PessoaFactory().makeInstance();
        pessoa.setNome(restEndpoint.getNome());
        pessoa.setIdade(restEndpoint.getIdade());
        return pessoa;
    }
}
