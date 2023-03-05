package com.vinicius123131.use_cases.criar_nova_pessoa.factories;

import com.vinicius123131.use_cases.criar_nova_pessoa.CriarNovaPessoa;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.CriarNovaPessoaImplementation;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.ArmazenamentoPesssoaPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarNovaPessoaUseCaseFactory {

    private final ArmazenamentoPesssoaPort armazenamentoPesssoaPort;

    public CriarNovaPessoa makeInstance(){
        return new CriarNovaPessoaImplementation(this.armazenamentoPesssoaPort);
    }
}
