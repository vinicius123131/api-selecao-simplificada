package com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.port_adapters;

import com.vinicius123131.entidades.OrganizacaoFila;
import com.vinicius123131.fila_plugins.data_base_configurations.repositories.OrganizacaoFilaTableEntityRepository;
import com.vinicius123131.fila_plugins.data_base_configurations.table_entities.mappers.OrganizacaoFIlaTableEntityMapper;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.exceptions.PessoaComPropriedadesInvalidasException;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.BuscarFilaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarFilaPortAdapter implements BuscarFilaPort {
    private final OrganizacaoFilaTableEntityRepository organizacaoFilaTableEntityRepository;
    private final OrganizacaoFIlaTableEntityMapper organizacaoFIlaTableEntityMapper;

    @Override
    public OrganizacaoFila execute(Long aLong) {
        var fila = this.organizacaoFilaTableEntityRepository.findById(aLong);
        if(fila.isPresent())
            return organizacaoFIlaTableEntityMapper.mepearParaOrganizacaoFila(fila.get());
        throw new PessoaComPropriedadesInvalidasException();
    }
}
