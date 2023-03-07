package com.vinicius123131.entidades;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class OrganizacaoFila {

    protected Long id;
    protected List<String> pessoasNaFila;
    protected List<String> filaAgendada;
    protected Integer QuantidadeDePessoasQueMuderamDeLugar;
}
