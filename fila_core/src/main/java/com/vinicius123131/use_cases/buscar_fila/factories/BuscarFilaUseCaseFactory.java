package com.vinicius123131.use_cases.buscar_fila.factories;

import com.vinicius123131.use_cases.buscar_fila.BuscarFila;
import com.vinicius123131.use_cases.buscar_fila.implementations.BuscarFilaImplementation;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.BuscarFilaPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscarFilaUseCaseFactory {

    private final BuscarFilaPort buscarFilaPort;

    public BuscarFila makeInstance(){
        return new BuscarFilaImplementation(this.buscarFilaPort);
    }
}
