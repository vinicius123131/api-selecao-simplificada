package com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.port_adapters;

import com.vinicius123131.entidades.OrganizacaoFila;
import com.vinicius123131.fila_plugins.data_base_configurations.repositories.OrganizacaoFilaTableEntityRepository;
import com.vinicius123131.fila_plugins.data_base_configurations.table_entities.mappers.OrganizacaoFIlaTableEntityMapper;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.OrganizacaoFilaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrganizacaoFilaPortAdapter implements OrganizacaoFilaPort {
    private final OrganizacaoFilaTableEntityRepository repository;
    private final OrganizacaoFIlaTableEntityMapper mapper;

    @Override
    public OrganizacaoFila execute(OrganizacaoFila organizacaoFila) {
        var adicionarFila = this.repository.save(this.mapper.mapearParaTableEntity(organizacaoFila));
        return null;
    }
}
