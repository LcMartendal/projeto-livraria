package org.example.pedido;

import org.example.modalidadesEntrega.ModalidadesEntrega;
import org.example.modalidadesEntrega.Pac;
import org.example.modalidadesEntrega.Sedex;
import org.example.produto.Produto;

import java.util.ArrayList;

public class Pedido {

    ArrayList<Produto> produtos;

    public Pedido(ArrayList<Produto> produtos) {
        this.produtos = produtos;
        produtos = new ArrayList<>();
    }

    public double calculoValorEntregaDoPedido(ModalidadesEntrega modalidadesEntrega) {
        switch (modalidadesEntrega) {
            case ENCOMENDA_PAC -> {
                var modalidadePac = new Pac();
                return modalidadePac.calculoDeCobrancaDaEntrega(calculaPesoTotalPedido());
            }
            case ENCOMENDA_SEDEX -> {
                var modalidadeSedex = new Sedex();
                return modalidadeSedex.calculoDeCobrancaDaEntrega(calculaPesoTotalPedido());
            }
            case RETIRADA_NA_LOJA -> {
                return 0;
            }
            default -> throw new RuntimeException("Modalidade de entrega não existe");
        }
    }

    private double calculaPesoTotalPedido() {
        return produtos.stream().mapToDouble(Produto::getPeso).sum();
    }
}
