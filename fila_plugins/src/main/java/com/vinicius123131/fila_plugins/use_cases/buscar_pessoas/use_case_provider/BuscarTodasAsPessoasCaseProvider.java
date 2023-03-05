package com.vinicius123131.fila_plugins.use_cases.buscar_pessoas.use_case_provider;

import com.vinicius123131.use_cases.buscar_pessoas.BuscarTodasAsPessoas;
import com.vinicius123131.use_cases.buscar_pessoas.factories.BuscarTodasAsPessoasUseCaseFactory;
import com.vinicius123131.use_cases.buscar_pessoas.implementations.ports.BuscarTodasAsPessoasPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BuscarTodasAsPessoasCaseProvider {

    private final BuscarTodasAsPessoasPort buscarTodasAsPessoasPort;

    @Bean
    public BuscarTodasAsPessoas buscarTodasAsPessoas(){
        return new BuscarTodasAsPessoasUseCaseFactory(this.buscarTodasAsPessoasPort).makeInstance();
    }
}
