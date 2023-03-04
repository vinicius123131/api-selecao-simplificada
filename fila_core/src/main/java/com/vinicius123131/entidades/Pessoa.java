package com.vinicius123131.entidades;

import com.vinicius123131.entidades.contracts.PessoaNaFila;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Pessoa implements PessoaNaFila {
    protected Long id;
    protected String nome;
    protected Integer idade;
    protected Long posicao_fila;
}
