package org.furb.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public double getPesoTotal() {
        return calculaPesoTotalDoPedido();
    }

    public double getValorTotal() {
        return calculaValorTotalDoPedido();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Usando o stream para mapear o objeto para double pegando o peso do produto
     * e por fim usando o sum para somar     * 
     * @return A soma do peso de todos produtos do pedido
     */
    private double calculaPesoTotalDoPedido() {
        return produtos.stream().mapToDouble(Produto::getPeso).sum();
    }

    /**
     * Usando o stream para mapear o objeto para double pegando o preço do produto
     * e por fim usando o sum para somar
     * @return A soma do preço de todos produtos do pedido
     */
    private double calculaValorTotalDoPedido() {
        return produtos.stream().mapToDouble(Produto::getPreco).sum();
    }
}