package com.vinicius123131.use_cases.criar_nova_pessoa.implementations;

import com.vinicius123131.entidades.Pessoa;
import com.vinicius123131.use_cases.criar_nova_pessoa.CriarNovaPessoa;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.exceptions.PessoaComPropriedadesInvalidasException;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.ArmazenamentoPesssoaPort;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class CriarNovaPessoaImplementation implements CriarNovaPessoa {

    private final ArmazenamentoPesssoaPort armazenamentoPesssoaPort;

    @Override
    public Pessoa execute(Pessoa input){
        if (input.temPropriedadesValidas()){
            input.setPosicao_fila(this.gerarLugarNaFila());
            System.out.println(input.getPosicao_fila() +"posição igual a");
            return this.armazenamentoPesssoaPort.execute(input);
        }
        throw new PessoaComPropriedadesInvalidasException();
    }
    private Integer gerarLugarNaFila(){
        Random rand = new Random();
        Integer lugar = rand.nextInt(991)+10;
        return lugar;
    }
}
