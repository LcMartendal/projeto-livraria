package br.furb.services;

import br.furb.models.Acao;
import br.furb.models.Ordem;

import java.math.BigDecimal;

public class MatchingService {

    private final NotificacaoService notificacaoService;

    public MatchingService(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    public void processar(Acao acao) {
        while (acao.temOrdens()) {
            Ordem compra = acao.melhorCompra().orElseThrow();
            Ordem venda = acao.melhorVenda().orElseThrow();

            if (compra.getValor().compareTo(venda.getValor()) >= 0) {
                BigDecimal precoExecucao = venda.getValor();
                acao.atualizarValor(precoExecucao);

                acao.removerMelhorCompra();
                acao.removerMelhorVenda();
            } else break;
        }
    }
}