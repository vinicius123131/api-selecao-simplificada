package com.vinicius123131.entidades.implementations;

import com.vinicius123131.entidades.Pessoa;
import com.vinicius123131.entidades.implementations.validation_rules.PessoaValidationRule;

import java.util.Arrays;
import java.util.List;

public class PessoaImplementation extends Pessoa {
    @Override
    public Boolean temPropriedadesValidas() {
        return this.nomeValido();
    }

    private Boolean nomeValido() {
        var nomes = this.separarNomeCompletoEmNomes();
        return nomes.size() >= PessoaValidationRule.MIN_SIZE && nomes.size() <= PessoaValidationRule.MAX_SIZE;
    }

    private List<String> separarNomeCompletoEmNomes() {
        return Arrays.asList(this.nome.split(" "));
    }
}
