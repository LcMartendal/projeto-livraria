package org.furb.frete;

import org.furb.model.Pedido;

public class RetiradaLoja implements TipoFrete {
    @Override
    public double calcularFrete(Pedido pedido) {
        return 0;
    }
}