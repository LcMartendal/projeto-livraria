package br.furb.services;

import br.furb.models.Ordem;

import java.math.BigDecimal;
import java.util.List;
import java.util.PriorityQueue;

public class AcaoMatcherService {

    private final NotificacaoService notificacaoService;

    public AcaoMatcherService() {
        this.notificacaoService = new NotificacaoService();
    }

    public void executarMatch(
            PriorityQueue<Ordem> compras,
            PriorityQueue<Ordem> vendas,
            BigDecimal valorAtualAcao
    ) {
        while (!compras.isEmpty() && !vendas.isEmpty()) {

            Ordem melhorCompra = compras.peek();
            Ordem melhorVenda = vendas.peek();

            if (melhorCompra.getValor().compareTo(melhorVenda.getValor()) == 0) {

                valorAtualAcao = melhorVenda.getValor();

                compras.poll();
                vendas.poll();

                notificacaoService.notificarInvestidores();

            } else {
                break;
            }
        }
    }
}
