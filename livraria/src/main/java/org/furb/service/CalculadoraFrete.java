package org.furb.service;

import org.furb.frete.TipoFrete;
import org.furb.model.Pedido;

public class CalculadoraFrete {

    public double calcular(Pedido pedido, TipoFrete tipoFrete) {
        return tipoFrete.calcularFrete(pedido);
    }
}