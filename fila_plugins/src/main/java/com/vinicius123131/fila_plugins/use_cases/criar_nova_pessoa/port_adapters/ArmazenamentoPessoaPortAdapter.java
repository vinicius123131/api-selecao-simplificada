package com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.port_adapters;

import com.vinicius123131.entidades.Pessoa;
import com.vinicius123131.fila_plugins.data_base_configurations.repositories.PessoaTableEntityRepository;
import com.vinicius123131.fila_plugins.data_base_configurations.table_entities.mappers.PessoaTableEntityMapper;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.ArmazenamentoPesssoaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArmazenamentoPessoaPortAdapter implements ArmazenamentoPesssoaPort {

    private final PessoaTableEntityRepository pessoaTableEntityRepository;
    private final PessoaTableEntityMapper pessoaTableEntityMapper;

    @Override
    public Pessoa execute(Pessoa input) {
        var pessoa = this.pessoaTableEntityMapper.mapearParaTableEntity(input);
        pessoa = this.pessoaTableEntityRepository.save(pessoa);
        return this.pessoaTableEntityMapper.mapearParaPessoa(pessoa);
    }
}
