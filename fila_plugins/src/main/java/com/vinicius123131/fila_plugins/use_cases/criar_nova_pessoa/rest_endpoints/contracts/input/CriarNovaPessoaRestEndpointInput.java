package com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.rest_endpoints.contracts.input;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CriarNovaPessoaRestEndpointInput {

    protected String nome;
    protected Integer idade;
}
