package br.furb.services;

import java.math.BigDecimal;

public class NotificacaoService {
    public void notificarInvestidores(
            String acao,
            BigDecimal novoValor,
            String nomeInvestidor
    ) {
        System.out.println(
                nomeInvestidor + " foi notificado: " +
                        acao + " agora vale " + novoValor
        );
    }
}
