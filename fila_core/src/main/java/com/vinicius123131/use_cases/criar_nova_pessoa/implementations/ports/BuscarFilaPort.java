package com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports;

import com.vinicius123131.entidades.OrganizacaoFila;
import com.vinicius123131.use_cases.contracts.FunctionPort;

public interface BuscarFilaPort extends FunctionPort<Long, OrganizacaoFila> {
}
