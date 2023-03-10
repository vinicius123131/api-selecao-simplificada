package com.vinicius123131.fila_plugins.use_cases.buscar_fila.rest_endpoints;

import com.vinicius123131.fila_plugins.rest_configurations.Resources;
import com.vinicius123131.fila_plugins.use_cases.buscar_fila.rest_endpoints.contracts.output.BuscarFilaRestEndpointOutput;
import com.vinicius123131.use_cases.buscar_fila.BuscarFila;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Resources.URL)
@RequiredArgsConstructor
public class BuscarUsuarioRestEndpoint {
    private final BuscarFila buscarFila;

    @GetMapping()
    public ResponseEntity<BuscarFilaRestEndpointOutput> buscarFila(){
        var fila = this.buscarFila.execute(1L);
        return ResponseEntity
                .status(200)
                .body(BuscarFilaRestEndpointOutput.of(fila));
    }
}
