package br.furb.services;

import br.furb.models.Acao;
import br.furb.models.UsuarioInvestidor;

public class NotificacaoService {

    public void notificar(Acao acao) {

        for (UsuarioInvestidor investidor : acao.getObservadores()) {

            investidor.notificar(
                    acao.getNome(),
                    acao.getValorAtual()
            );
        }
    }
}

