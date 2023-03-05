package com.vinicius123131.fila_plugins.data_base_configurations.table_entities.mappers;

import com.vinicius123131.entidades.Pessoa;
import com.vinicius123131.entidades.factories.PessoaFactory;
import com.vinicius123131.fila_plugins.data_base_configurations.table_entities.PessoaTableEntity;
import org.springframework.stereotype.Component;

@Component
public class PessoaTableEntityMapper {
    public Pessoa mapearParaPessoa(PessoaTableEntity pessoaTableEntity){
        var pessoa = new PessoaFactory().makeInstance();
        pessoa.setNome(pessoaTableEntity.getNome());
        pessoa.setIdade(pessoaTableEntity.getIdade());
        pessoa.setPosicao_fila(pessoaTableEntity.getPosicao_fila());
        pessoa.setId(pessoaTableEntity.getId());
        return pessoa;
    }
    public PessoaTableEntity mapearParaTableEntity(Pessoa pessoa){
        return PessoaTableEntity.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .idade(pessoa.getIdade())
                .posicao_fila(pessoa.getPosicao_fila())
                .build();
    }
}
