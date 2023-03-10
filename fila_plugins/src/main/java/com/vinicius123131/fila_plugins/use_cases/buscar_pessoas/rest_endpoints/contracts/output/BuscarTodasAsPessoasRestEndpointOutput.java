package com.vinicius123131.fila_plugins.use_cases.buscar_pessoas.rest_endpoints.contracts.output;

import com.vinicius123131.entidades.Pessoa;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BuscarTodasAsPessoasRestEndpointOutput {

    private List<String> pessoas;

    public static BuscarTodasAsPessoasRestEndpointOutput of (List<Pessoa> pessoasDaFila){
        List<String> pessoas = new ArrayList<>();
        for (Pessoa pessoa : pessoasDaFila){
            pessoas.add(pessoa.getNome()+". posição na fila: "+ pessoa.getPosicao_fila());

        }
        return new BuscarTodasAsPessoasRestEndpointOutput(pessoas);
    }
}



