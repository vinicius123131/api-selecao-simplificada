package com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.rest_endpoints.contracts.output;

import com.vinicius123131.entidades.Pessoa;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CriarNovaPessoaRestEndpointOutput {

    private final String nomeMaisPosicaoLista;

    public static CriarNovaPessoaRestEndpointOutput of(Pessoa pessoaRecemCriada){
        return new CriarNovaPessoaRestEndpointOutput(pessoaRecemCriada.getNome() + " posição: "+pessoaRecemCriada.getPosicao_fila());
    }
}
