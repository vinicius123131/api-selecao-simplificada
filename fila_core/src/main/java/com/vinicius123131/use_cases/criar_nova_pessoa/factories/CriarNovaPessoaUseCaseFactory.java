package com.vinicius123131.use_cases.criar_nova_pessoa.factories;

import com.vinicius123131.use_cases.criar_nova_pessoa.CriarNovaPessoa;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.CriarNovaPessoaImplementation;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.ArmazenamentoPesssoaPort;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.BuscarFilaPort;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.OrganizacaoFilaPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarNovaPessoaUseCaseFactory {

    private final ArmazenamentoPesssoaPort armazenamentoPesssoaPort;
    private final BuscarFilaPort buscarFilaPort;
    private final OrganizacaoFilaPort organizacaoFilaPort;

    public CriarNovaPessoa makeInstance(){
        return new CriarNovaPessoaImplementation(this.armazenamentoPesssoaPort,this.organizacaoFilaPort, this.buscarFilaPort);
    }
}
