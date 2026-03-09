package org.example.frete;

import org.example.model.Pedido;

public class RetiradaLoja implements TipoFrete {

    @Override
    public double calcularFrete(Pedido pedido) {
        return 0;
    }
}