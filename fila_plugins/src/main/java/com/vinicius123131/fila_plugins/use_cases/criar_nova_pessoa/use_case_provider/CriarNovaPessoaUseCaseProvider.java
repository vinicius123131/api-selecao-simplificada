package com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.use_case_provider;
import com.vinicius123131.use_cases.criar_nova_pessoa.CriarNovaPessoa;
import com.vinicius123131.use_cases.criar_nova_pessoa.factories.CriarNovaPessoaUseCaseFactory;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.ArmazenamentoPesssoaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CriarNovaPessoaUseCaseProvider {

    private final ArmazenamentoPesssoaPort armazenamentoPesssoaPort;

    @Bean
    public CriarNovaPessoa criarNovaPessoa(){
        return new CriarNovaPessoaUseCaseFactory(this.armazenamentoPesssoaPort).makeInstance();
    }
}
