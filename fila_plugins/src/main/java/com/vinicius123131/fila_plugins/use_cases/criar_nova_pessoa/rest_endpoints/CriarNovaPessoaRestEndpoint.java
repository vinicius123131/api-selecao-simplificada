package com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.rest_endpoints;

import com.vinicius123131.entidades.factories.OrganizacaoFilaFactory;
import com.vinicius123131.fila_plugins.data_base_configurations.repositories.OrganizacaoFilaTableEntityRepository;
import com.vinicius123131.fila_plugins.data_base_configurations.table_entities.OrganizacaoFilaTableEntity;
import com.vinicius123131.fila_plugins.data_base_configurations.table_entities.mappers.OrganizacaoFIlaTableEntityMapper;
import com.vinicius123131.fila_plugins.rest_configurations.Resources;
import com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.rest_endpoints.contracts.input.CriarNovaPessoaRestEndpointInput;
import com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.rest_endpoints.contracts.input.mappers.CriarNovaPessoaRestEndpointInputMapper;
import com.vinicius123131.fila_plugins.use_cases.criar_nova_pessoa.rest_endpoints.contracts.output.CriarNovaPessoaRestEndpointOutput;
import com.vinicius123131.use_cases.criar_nova_pessoa.CriarNovaPessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(Resources.URL)
@RequiredArgsConstructor
public class CriarNovaPessoaRestEndpoint {

    private final CriarNovaPessoa criarNovaPessoa;
    private final OrganizacaoFilaTableEntityRepository organizacaoFilaTableEntityRepository;
    private final CriarNovaPessoaRestEndpointInputMapper criarNovaPessoaRestEndpointInputMapper;
    private final OrganizacaoFIlaTableEntityMapper organizacaoFIlaTableEntityMapper;

    @PostMapping
    public ResponseEntity<CriarNovaPessoaRestEndpointOutput> criarNovaPessoa(@RequestBody CriarNovaPessoaRestEndpointInput input){
        var pessoaRecemCriada = this.criarNovaPessoa.execute(this.criarNovaPessoaRestEndpointInputMapper.map(input));
        return ResponseEntity
                .status(201)
                .body(CriarNovaPessoaRestEndpointOutput.of(pessoaRecemCriada));
    }
    @GetMapping("/teste")
    public String criarAlgo(){
        var orga = new OrganizacaoFilaFactory().makeInstance();
        orga.setId(1L);
        orga.setPessoasNaFila(new ArrayList<>());
        orga.setFilaAgendada(new ArrayList<>());
        orga.setQuantidadeDePessoasQueMuderamDeLugar(0);
        organizacaoFilaTableEntityRepository.save(organizacaoFIlaTableEntityMapper.mapearParaTableEntity(orga));
        return "Deu bom";
    }
}
