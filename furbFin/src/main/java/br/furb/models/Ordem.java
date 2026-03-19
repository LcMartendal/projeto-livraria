package br.furb.models;

import br.furb.models.enums.TipoOrdem;
import br.furb.validators.OrdemValidator;

import java.math.BigDecimal;
import java.util.Objects;

public class Ordem {

    private final UsuarioInvestidor investidor;
    private final TipoOrdem tipo;
    private final BigDecimal valor;

    public Ordem(UsuarioInvestidor investidor, TipoOrdem tipo, BigDecimal valor) {
        OrdemValidator validator = new OrdemValidator();
        validator.validar(investidor, tipo, valor);

        this.investidor = Objects.requireNonNull(investidor);
        this.tipo = Objects.requireNonNull(tipo);
        this.valor = Objects.requireNonNull(valor);

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
    }

    public void adicionarNaAcao(Acao acao) {
        switch (tipo) {
            case COMPRA -> acao.adicionarCompra(this);
            case VENDA -> acao.adicionarVenda(this);
        }
    }

    public UsuarioInvestidor getInvestidor() {
        return investidor;
    }

    public TipoOrdem getTipoOrdem() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }
}