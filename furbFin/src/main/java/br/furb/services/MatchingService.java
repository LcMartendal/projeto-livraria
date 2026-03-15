package br.furb.services;

import br.furb.models.Acao;
import br.furb.models.Ordem;

import java.math.BigDecimal;

public class MatchingService {

    private final NotificacaoService notificacaoService;

    public MatchingService() {
        this.notificacaoService = new NotificacaoService();
    }

    public void processar(Acao acao) {

        while (acao.temCompras() && acao.temVendas()) {

            Ordem melhorCompra = acao.melhorCompra();
            Ordem melhorVenda = acao.melhorVenda();

            if (melhorCompra.getValor().compareTo(melhorVenda.getValor()) == 0) {

                BigDecimal novoValor = melhorVenda.getValor();

                acao.setValorAtual(novoValor);

                acao.removerMelhorCompra();
                acao.removerMelhorVenda();

                notificacaoService.notificar(acao);

            } else {
                break;
            }
        }
    }
}
