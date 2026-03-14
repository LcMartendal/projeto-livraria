package br.furb.models;

import br.furb.enuns.TipoOrdem;

import java.math.BigDecimal;

public class Ordem {
    private String nomeInvestidor;
    private TipoOrdem tipoOrdem;
    private BigDecimal valor;

    public Ordem(String nomeInvestidor, TipoOrdem tipoOrdem, BigDecimal valor) {
        this.nomeInvestidor = nomeInvestidor;
        this.tipoOrdem = tipoOrdem;
        this.valor = valor;
    }

    public String getNomeInvestidor() {
        return nomeInvestidor;
    }

    public TipoOrdem getTipoOrdem() {
        return tipoOrdem;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
