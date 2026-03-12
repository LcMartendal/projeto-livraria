package org.example.frete;

import org.example.model.Pedido;

public interface TipoFrete {
    double calcularFrete(Pedido pedido);
}