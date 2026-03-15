package br.furb.models;

import br.furb.models.enums.TipoOrdem;

import java.math.BigDecimal;

public class Ordem {
    private UsuarioInvestidor investidor;
    private TipoOrdem tipoOrdem;
    private BigDecimal valor;

    public Ordem(String nomeInvestidor, TipoOrdem tipoOrdem, BigDecimal valor) {
        this.investidor = new UsuarioInvestidor(nomeInvestidor);
        this.tipoOrdem = tipoOrdem;
        this.valor = valor;
    }

    public UsuarioInvestidor getInvestidor() {
        return investidor;
    }

    public TipoOrdem getTipoOrdem() {
        return tipoOrdem;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
