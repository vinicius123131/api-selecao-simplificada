package com.vinicius123131.fila_plugins.data_base_configurations.table_entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganizacaoFilaTableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> pessoasNaFila;

    @ElementCollection
    private List<String> filaAgendada;
    private Integer quantidadeDePessoasQueMudaramDeLugar;
}
