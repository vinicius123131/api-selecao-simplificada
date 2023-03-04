package com.vinicius123131.entidades.factories;

import com.vinicius123131.entidades.Pessoa;
import com.vinicius123131.entidades.factories.contracts.EntidadesFactory;
import com.vinicius123131.entidades.implementations.PessoaImplementation;

public class PessoaFactory implements EntidadesFactory<Pessoa> {

    @Override
    public Pessoa makeInstance() {
        return new PessoaImplementation();
    }
}
