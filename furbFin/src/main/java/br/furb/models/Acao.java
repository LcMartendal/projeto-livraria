package br.furb.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Acao {
    private String nome;
    private BigDecimal valorAtual;

    private List<Ordem> ordens = new ArrayList<>();
    private List<UsuarioInvestidor> investidoresObservadores = new ArrayList<>();

    public Acao(String nome, BigDecimal valorAtual) {
        this.nome = nome;
        this.valorAtual = valorAtual;
    }

    public void registrarInvestidor(UsuarioInvestidor investidor) {
        investidoresObservadores.add(investidor);
    }

    public void adicionarOrdem(Ordem ordem) {
        ordens.add(ordem);
        verificarMatch();
    }

    private void notificarInvestidores() {

        for (Investidor inv : observadores) {
            inv.notificar(nome, valorAtual);
        }
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValorAtual() {
        return valorAtual;
    }

    public List<UsuarioInvestidor> getInvestidoresObservadores() {
        return investidoresObservadores;
    }
}
