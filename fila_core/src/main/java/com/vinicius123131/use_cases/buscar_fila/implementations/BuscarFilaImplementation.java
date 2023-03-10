package com.vinicius123131.use_cases.buscar_fila.implementations;

import com.vinicius123131.entidades.OrganizacaoFila;
import com.vinicius123131.use_cases.buscar_fila.BuscarFila;
import com.vinicius123131.use_cases.buscar_fila.implementations.exceptions.FilaNaoEncontrada;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.exceptions.PessoaComPropriedadesInvalidasException;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.BuscarFilaPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscarFilaImplementation implements BuscarFila {
    private final BuscarFilaPort buscarFilaPort;
    @Override
    public OrganizacaoFila execute(Long input) throws PessoaComPropriedadesInvalidasException {
        try{
            return this.buscarFilaPort.execute(input);
        }catch (RuntimeException e){
            throw new FilaNaoEncontrada();
        }
    }
}
