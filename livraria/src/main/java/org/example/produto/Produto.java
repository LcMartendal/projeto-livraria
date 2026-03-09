package org.example.produto;

public class Produto {

    private String nome;
    private double valor;
    private double peso;

    public Produto(String nome, double valor, double peso) {
        this.nome = nome;
        this.valor = valor;
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }
}
