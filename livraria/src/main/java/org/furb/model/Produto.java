package org.furb.model;

import org.furb.validator.ProdutoValidator;

public class Produto {
    private String nome;
    private double peso;
    private double preco;
    private final ProdutoValidator produtoValidator;

    public Produto(String nome, double peso, double preco) {
        this.produtoValidator = new ProdutoValidator();
        produtoValidator.validarCampos(nome, peso, preco);
        
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
    }

    public double getPeso() {
        return peso;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}