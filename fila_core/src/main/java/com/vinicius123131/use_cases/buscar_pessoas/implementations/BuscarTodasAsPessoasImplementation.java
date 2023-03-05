package com.vinicius123131.use_cases.buscar_pessoas.implementations;

import com.vinicius123131.entidades.Pessoa;
import com.vinicius123131.use_cases.buscar_pessoas.implementations.ports.BuscarTodasAsPessoasPort;
import com.vinicius123131.use_cases.buscar_pessoas.BuscarTodasAsPessoas;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class BuscarTodasAsPessoasImplementation implements BuscarTodasAsPessoas {

    private final BuscarTodasAsPessoasPort buscarTodasAsPessoasPort;
    @Override
    public List<Pessoa> execute() {
        var pessoas = this.buscarTodasAsPessoasPort.execute();
        return this.organizarFila(pessoas);
    }

    private List<Pessoa> organizarFila(List<Pessoa> pessoas) {
        Collections.sort(pessoas, (Pessoa p1, Pessoa p2) -> p2.getPosicao_fila() - p1.getPosicao_fila());
        return pessoas;
    }

}
