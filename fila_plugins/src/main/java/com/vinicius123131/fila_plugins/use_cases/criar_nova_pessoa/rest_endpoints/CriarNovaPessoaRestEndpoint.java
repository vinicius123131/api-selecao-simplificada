package com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.rest_endpoints;

import com.vinicius123131.fila_plugins.rest_configurations.Resources;
import com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.rest_endpoints.contracts.input.CriarNovaPessoaRestEndpointInput;
import com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.rest_endpoints.contracts.input.mappers.CriarNovaPessoaRestEndpointInputMapper;
import com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.rest_endpoints.contracts.output.CriarNovaPessoaRestEndpointOutput;
import com.vinicius123131.use_cases.criar_nova_pessoa.CriarNovaPessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Resources.URL)
@RequiredArgsConstructor
public class CriarNovaPessoaRestEndpoint {

    private final CriarNovaPessoa criarNovaPessoa;
    private final CriarNovaPessoaRestEndpointInputMapper criarNovaPessoaRestEndpointInputMapper;

    @PostMapping
    public ResponseEntity<CriarNovaPessoaRestEndpointOutput> criarNovaPessoa(@RequestBody CriarNovaPessoaRestEndpointInput input){
        var pessoaRecemCriada = this.criarNovaPessoa.execute(this.criarNovaPessoaRestEndpointInputMapper.map(input));
        return ResponseEntity
                .status(201)
                .body(CriarNovaPessoaRestEndpointOutput.of(pessoaRecemCriada));
    }
}
