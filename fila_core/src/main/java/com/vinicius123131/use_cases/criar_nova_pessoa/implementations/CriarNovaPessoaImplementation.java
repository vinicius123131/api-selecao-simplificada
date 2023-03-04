package com.vinicius123131.use_cases.criar_nova_pessoa.implementations;

import com.vinicius123131.entidades.Pessoa;
import com.vinicius123131.use_cases.criar_nova_pessoa.CriarNovaPessoa;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.exceptions.PessoaComPropriedadesInvalidasException;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.ArmazenamentoPesssoaPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarNovaPessoaImplementation implements CriarNovaPessoa {

    private final ArmazenamentoPesssoaPort armazenamentoPesssoaPort;

    @Override
    public Pessoa execute(Pessoa input) {
        if (input.temPropriedadesValidas())
            return this.armazenamentoPesssoaPort.execute(input);
        throw new PessoaComPropriedadesInvalidasException();
    }
}
