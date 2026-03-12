package org.furb.model;

import org.furb.validator.PesoValidador;
import org.furb.validator.PrecoValidator;
import org.furb.validator.ProdutoValidator;
import org.furb.validator.Validador;

public class Produto {
    private String nome;
    private double peso;
    private double preco;

    private final Validador<Double> pesoValidador = new PesoValidador();
    private final Validador<Double> precoValidator = new PrecoValidator();
    private final Validador<String> produtoValidador = new ProdutoValidator();

    public Produto(String nome, double peso, double preco) {

        pesoValidador.validar(peso);
        precoValidator.validar(preco);
        produtoValidador.validar(nome);

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