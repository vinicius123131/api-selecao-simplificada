package com.vinicius123131.use_cases.buscar_fila.implementations.exceptions;

public class FilaNaoEncontrada extends RuntimeException{
    public FilaNaoEncontrada(){
        super("Fila não encontrada na base de dado");
    }
}
