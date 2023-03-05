package com.vinicius123131.fila_plugins.data_base_configurations.repositories;

import com.vinicius123131.fila_plugins.data_base_configurations.table_entities.PessoaTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaTableEntityRepository extends JpaRepository<PessoaTableEntity, Long> {
}
