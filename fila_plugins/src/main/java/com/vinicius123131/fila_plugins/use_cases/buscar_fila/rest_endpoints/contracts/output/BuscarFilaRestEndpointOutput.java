package com.vinicius123131.fila_plugins.use_cases.buscar_fila.rest_endpoints.contracts.output;

import com.vinicius123131.entidades.OrganizacaoFila;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BuscarFilaRestEndpointOutput {

    private final String quantidadeDePessoasQueMudaramDeLugar;

    private final List<String> usuarioComSuasPosicoes;

    public static BuscarFilaRestEndpointOutput of (OrganizacaoFila organizacaoFila){
        return new BuscarFilaRestEndpointOutput("Quantidade De pessoas que muderam de lugar: "+organizacaoFila.getQuantidadeDePessoasQueMuderamDeLugar(), organizacaoFila.getPessoasNaFila());
    }
}
