package br.furb.services;

import br.furb.models.Acao;
import br.furb.models.Ordem;
import br.furb.models.enums.TipoOrdem;

import java.util.HashMap;
import java.util.Map;

public class BolsaDeValoresService {

    private Map<String, Acao> acoes = new HashMap<>();

    private MatchingService matchingService;

    public BolsaDeValoresService() {
        this.matchingService = new MatchingService();
    }

    public void adicionarAcao(Acao acao) {
        acoes.put(acao.getNome(), acao);
    }

    public void registrarOrdem(String nomeAcao, Ordem ordem) {
        Acao acao = acoes.get(nomeAcao);

        if (acao == null) throw new RuntimeException("Ação não encontrada");

        if (ordem.getTipoOrdem() == TipoOrdem.COMPRA) {
            acao.adicionarCompra(ordem);
        } else {
            acao.adicionarVenda(ordem);
        }

        matchingService.processar(acao);
    }
}

