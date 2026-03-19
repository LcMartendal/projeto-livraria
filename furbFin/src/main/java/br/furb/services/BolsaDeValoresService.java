package br.furb.services;

import br.furb.models.Acao;
import br.furb.models.Ordem;

import java.util.HashMap;
import java.util.Map;

public class BolsaDeValoresService {

    private final Map<String, Acao> acoes = new HashMap<>();
    private final MatchingService matchingService;

    public BolsaDeValoresService(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    public void adicionarAcao(Acao acao) {
        acoes.put(acao.getNome(), acao);
    }

    public void registrarOrdem(String nomeAcao, Ordem ordem) {

        Acao acao = buscarAcao(nomeAcao);

        acao.adicionarOrdem(ordem);

        matchingService.processar(acao);
    }

    private Acao buscarAcao(String nome) {
        Acao acao = acoes.get(nome);

        if (acao == null) {
            throw new IllegalArgumentException("Ação não encontrada");
        }

        return acao;
    }
}