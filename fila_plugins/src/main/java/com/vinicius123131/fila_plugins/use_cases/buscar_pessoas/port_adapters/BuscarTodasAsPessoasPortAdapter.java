package com.vinicius123131.fila_plugins.use_cases.buscar_pessoas.port_adapters;

import com.vinicius123131.entidades.Pessoa;
import com.vinicius123131.fila_plugins.data_base_configurations.repositories.PessoaTableEntityRepository;
import com.vinicius123131.fila_plugins.data_base_configurations.table_entities.PessoaTableEntity;
import com.vinicius123131.fila_plugins.data_base_configurations.table_entities.mappers.PessoaTableEntityMapper;
import com.vinicius123131.use_cases.buscar_pessoas.implementations.ports.BuscarTodasAsPessoasPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarTodasAsPessoasPortAdapter implements BuscarTodasAsPessoasPort {
    private final PessoaTableEntityRepository pessoaTableEntityRepository;

    private final PessoaTableEntityMapper pessoaTableEntityMapper;

    @Override
    public List<Pessoa> execute() {
        var pessoasTableEntities = this.pessoaTableEntityRepository.findAll();
        List<Pessoa> pessoas = new ArrayList<>();
        for (PessoaTableEntity pessoaTableEntity: pessoasTableEntities)
            pessoas.add(this.pessoaTableEntityMapper.mapearParaPessoa(pessoaTableEntity));
        return pessoas;
    }
}
