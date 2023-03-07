package com.vinicius123131.use_cases.criar_nova_pessoa.implementations;

import com.vinicius123131.entidades.OrganizacaoFila;
import com.vinicius123131.entidades.Pessoa;
import com.vinicius123131.entidades.factories.OrganizacaoFilaFactory;
import com.vinicius123131.use_cases.criar_nova_pessoa.CriarNovaPessoa;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.exceptions.PessoaComPropriedadesInvalidasException;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.ArmazenamentoPesssoaPort;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.BuscarFilaPort;
import com.vinicius123131.use_cases.criar_nova_pessoa.implementations.ports.OrganizacaoFilaPort;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class CriarNovaPessoaImplementation implements CriarNovaPessoa {
    private final ArmazenamentoPesssoaPort armazenamentoPesssoaPort;
    private final OrganizacaoFilaPort organizacaoFilaPort;
    private final BuscarFilaPort buscarFilaPort;

    @Override
    public Pessoa execute(Pessoa input){
        if (input.temPropriedadesValidas()){
            input.setPosicao_fila(this.gerarLugarNaFila());
            String novaPessoaFila = input.getNome()+". posição igual a "+ input.getPosicao_fila();
            this.adicionarPessoaNaFila(novaPessoaFila);
            return this.armazenamentoPesssoaPort.execute(input);
        }
        throw new PessoaComPropriedadesInvalidasException();
    }
    private Integer gerarLugarNaFila(){
        Random rand = new Random();
        Integer lugar = rand.nextInt(991)+10;
        return lugar;
    }
    private List<String> buscarFila(){
        OrganizacaoFila organizacao = buscarFilaPort.execute(Long.valueOf(1));
        return organizacao.getPessoasNaFila();
    }
    private List<String> buscarFilaAgendada(){
        OrganizacaoFila organizacaoFila = buscarFilaPort.execute(Long.valueOf(1));
        return organizacaoFila.getFilaAgendada();
    }
    /*private void adicionarPessoaNaFila(String pessoa){
        final List<String> filaAgendada = buscarFilaAntiga();
        List<String> filaAntiga = buscarFilaAntiga();
        filaAgendada.add(pessoa);
        List<String> novaFilaOrganizada = this.organizarFila(filaAgendada);
        OrganizacaoFila novaOrganizacao = new OrganizacaoFilaFactory().makeInstance();
        novaOrganizacao.setId(1L);
        novaOrganizacao.setPessoasNaFila(novaFilaOrganizada);
        organizacaoFilaPort.execute(novaOrganizacao);
    }*/
    private void adicionarPessoaNaFila(String pessoa){
        List<String> fila = this.buscarFila();
        List<String> filaAgendada = this.buscarFilaAgendada();
        fila.add(pessoa);
        List<String> filaOrganizada = this.organizarFila(fila);
        int quantasPessoasTrocaram = this.contarQuantasPessoasMuderamDeLugar(filaOrganizada, filaAgendada);
        OrganizacaoFila novaOrganizacao = new OrganizacaoFilaFactory().makeInstance();
        novaOrganizacao.setId(1L);
        novaOrganizacao.setPessoasNaFila(filaOrganizada);
        novaOrganizacao.setFilaAgendada(filaOrganizada);
        novaOrganizacao.setQuantidadeDePessoasQueMuderamDeLugar(quantasPessoasTrocaram);
        organizacaoFilaPort.execute(novaOrganizacao);
    }

    private int contarQuantasPessoasMuderamDeLugar(List<String> fila, List<String> filaAgendada) {
        int contador = 0;
        for (int i = 0; i < fila.size() -2; i++) {
            if (filaAgendada.contains(fila.get(i))){
                if (!fila.get(i).equals(filaAgendada.get(i)))
                    contador++;
            }
            System.out.println(contador);
        }
        return contador+2;
    }

    private List<String> organizarFila(List<String> pessoas){
        Collections.sort(pessoas, (p1, p2) ->{
            String[] parts1 = p1.split("\\s+");
            String[] parts2 = p2.split("\\s+");
            int numero1 = Integer.parseInt(parts1[parts1.length-1]);
            int numero2 = Integer.parseInt(parts2[parts2.length-1]);
            int comparacao = Integer.compare(numero2, numero1);
            return comparacao;
        });
        return pessoas;
    }
}
