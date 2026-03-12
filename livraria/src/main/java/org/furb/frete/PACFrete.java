package org.furb.frete;

import org.furb.model.Pedido;

public class PACFrete implements TipoFrete {
    @Override
    public double calcularFrete(Pedido pedido) {

        double peso = pedido.getPesoTotal();

        if (peso <= 1) {
            return 10.0;
        }

        if (peso <= 2) {
            return 15.0;
        }

        throw new IllegalArgumentException("PAC não aceita pedidos acima de 2kg");
    }
}