package com.vinicius123131.use_cases.buscar_pessoas.implementations.ports;

import com.vinicius123131.entidades.Pessoa;
import com.vinicius123131.use_cases.contracts.SupplierPort;

import java.util.List;

public interface BuscarTodasAsPessoasPort extends SupplierPort<List<Pessoa>> {
}
