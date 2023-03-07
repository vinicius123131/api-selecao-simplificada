package com.vinicius123131.entidades.factories;

import com.vinicius123131.entidades.OrganizacaoFila;
import com.vinicius123131.entidades.factories.contracts.EntidadesFactory;
import com.vinicius123131.entidades.implementations.OrganizacaoFilaImplementation;

public class OrganizacaoFilaFactory implements EntidadesFactory<OrganizacaoFila> {
    @Override
    public OrganizacaoFila makeInstance() {
        return new OrganizacaoFilaImplementation();
    }
}
