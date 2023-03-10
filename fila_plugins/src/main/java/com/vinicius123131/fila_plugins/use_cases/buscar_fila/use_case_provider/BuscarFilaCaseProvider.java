package com.vinicius123131.fila_plugins.use_cases.buscar_fila.use_case_provider;

import com.vinicius123131.use_cases.buscar_fila.BuscarFila;
import com.vinicius123131.use_cases.buscar_fila.factories.BuscarFilaUseCaseFactory;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.BuscarFilaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BuscarFilaCaseProvider {

    private final BuscarFilaPort buscarFilaPort;

    @Bean
    public BuscarFila buscarFila(){
        return new BuscarFilaUseCaseFactory(this.buscarFilaPort).makeInstance();
    }
}
