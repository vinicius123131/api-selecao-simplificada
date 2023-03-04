package com.vinicius123131.use_cases.criar_nova_pessoa.implementations.exceptions;

public class PessoaComPropriedadesInvalidasException extends RuntimeException{

    public PessoaComPropriedadesInvalidasException(){
        super("Propriedades inválidas na criação de uma nova pessoa na fila");
    }
}
