package com.vinicius123131.use_cases.buscar_pessoas.factories;

import com.vinicius123131.use_cases.buscar_pessoas.BuscarTodasAsPessoas;
import com.vinicius123131.use_cases.buscar_pessoas.implementations.BuscarTodasAsPessoasImplementation;
import com.vinicius123131.use_cases.buscar_pessoas.implementations.ports.BuscarTodasAsPessoasPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscarTodasAsPessoasUseCaseFactory {

    private final BuscarTodasAsPessoasPort buscarTodasAsPessoasPort;

    public BuscarTodasAsPessoas makeInstance(){
        return new BuscarTodasAsPessoasImplementation(this.buscarTodasAsPessoasPort);
    }
}
