package com.vinicius123131.fila_plugins.data_base_configurations.repositories;

import com.vinicius123131.fila_plugins.data_base_configurations.table_entities.OrganizacaoFilaTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizacaoFilaTableEntityRepository extends JpaRepository<OrganizacaoFilaTableEntity, Long> {
}
