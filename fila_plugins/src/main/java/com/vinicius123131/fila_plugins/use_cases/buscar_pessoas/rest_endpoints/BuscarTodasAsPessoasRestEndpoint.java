package com.vinicius123131.fila_plugins.use_cases.buscar_pessoas.rest_endpoints;

import com.vinicius123131.fila_plugins.rest_configurations.Resources;
import com.vinicius123131.fila_plugins.use_cases.buscar_pessoas.rest_endpoints.contracts.output.BuscarTodasAsPessoasRestEndpointOutput;
import com.vinicius123131.use_cases.buscar_pessoas.BuscarTodasAsPessoas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Resources.URL)
@RequiredArgsConstructor
public class BuscarTodasAsPessoasRestEndpoint {

    private final BuscarTodasAsPessoas buscarTodasAsPessoas;

    private final BuscarTodasAsPessoasRestEndpointOutput buscarTodasAsPessoasRestEndpointOutput;

    @GetMapping
    public ResponseEntity<BuscarTodasAsPessoasRestEndpointOutput> buscarTodasAsPessoas(){
        var pessoasDaFila = this.buscarTodasAsPessoas.execute();
        return ResponseEntity
                .status(200)
                .body(BuscarTodasAsPessoasRestEndpointOutput.of(pessoasDaFila));
    }
}
