package org.example.service;

import org.example.frete.TipoFrete;
import org.example.model.Pedido;

public class CalculadoraFrete {

    public double calcular(Pedido pedido, TipoFrete tipoFrete) {
        return tipoFrete.calcularFrete(pedido);
    }
}