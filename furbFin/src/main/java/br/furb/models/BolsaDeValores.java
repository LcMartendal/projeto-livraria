package br.furb.models;

import java.util.HashMap;
import java.util.Map;

public class BolsaDeValores {
    private Map<String, Acao> acoes = new HashMap<>();

    public void adicionarAcao(Acao acao) {
        acoes.put(acao.getNome(), acao);
    }

    public Acao buscarAcao(String nome) {
        return acoes.get(nome);
    }
}
