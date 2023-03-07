package com.vinicius123131.fila_plugins.data_base_configurations.table_entities.mappers;

import com.vinicius123131.entidades.OrganizacaoFila;
import com.vinicius123131.entidades.factories.OrganizacaoFilaFactory;
import com.vinicius123131.fila_plugins.data_base_configurations.table_entities.OrganizacaoFilaTableEntity;
import org.springframework.stereotype.Component;

@Component
public class OrganizacaoFIlaTableEntityMapper {

    public OrganizacaoFila mepearParaOrganizacaoFila(OrganizacaoFilaTableEntity organizacaoFilaTableEntity){
        var organizacao = new OrganizacaoFilaFactory().makeInstance();
        organizacao.setId(organizacaoFilaTableEntity.getId());
        organizacao.setPessoasNaFila(organizacaoFilaTableEntity.getPessoasNaFila());
        organizacao.setFilaAgendada(organizacaoFilaTableEntity.getFilaAgendada());
        organizacao.setQuantidadeDePessoasQueMuderamDeLugar(organizacaoFilaTableEntity.getQuantidadeDePessoasQueMudaramDeLugar());
        return organizacao;
    }
    public OrganizacaoFilaTableEntity mapearParaTableEntity(OrganizacaoFila organizacaoFila){
        return OrganizacaoFilaTableEntity.builder()
                .id(organizacaoFila.getId())
                .pessoasNaFila(organizacaoFila.getPessoasNaFila())
                .quantidadeDePessoasQueMudaramDeLugar(organizacaoFila.getQuantidadeDePessoasQueMuderamDeLugar())
                .filaAgendada(organizacaoFila.getFilaAgendada())
                .build();
    }
}
