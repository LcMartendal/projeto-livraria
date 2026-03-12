package org.furb.frete;

import org.furb.model.Pedido;

public interface TipoFrete {
    double calcularFrete(Pedido pedido);
}