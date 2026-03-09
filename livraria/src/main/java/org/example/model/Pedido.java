package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public double getPesoTotal() {
        double peso = 0;

        for (Produto p : produtos) {
            peso += p.getPeso();
        }

        return peso;
    }

    public double getValorTotal() {
        double valor = 0;

        for (Produto p : produtos) {
            valor += p.getPreco();
        }

        return valor;
    }
}