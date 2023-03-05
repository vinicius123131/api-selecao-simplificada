package com.vinicius123131.use_cases.contracts;

import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.exceptions.PessoaComPropriedadesInvalidasException;

public interface FunctionUseCase <I, O>{
    O execute(I input) throws PessoaComPropriedadesInvalidasException;
}
