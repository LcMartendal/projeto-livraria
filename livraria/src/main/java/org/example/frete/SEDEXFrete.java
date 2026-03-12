package org.example.frete;

import org.example.model.Pedido;

public class SEDEXFrete implements TipoFrete {
    @Override
    public double calcularFrete(Pedido pedido) {

        double peso = pedido.getPesoTotal();

        if (peso <= 0.5) {
            return 12.5;
        }

        if (peso <= 1) {
            return 20.0;
        }

        double adicional = peso - 1;

        int blocos100g = (int) Math.ceil(adicional / 0.1);

        return 46.5 + (blocos100g * 1.5);
    }
}