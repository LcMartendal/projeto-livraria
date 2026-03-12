package org.furb;

import org.furb.frete.PACFrete;
import org.furb.frete.RetiradaLoja;
import org.furb.frete.SEDEXFrete;
import org.furb.model.Pedido;
import org.furb.model.Produto;
import org.furb.service.CalculadoraFrete;

public class Main {

    public static void main(String[] args) {

        Produto livro1 = new Produto("Clean Code", 0.6, 120);
        Produto livro2 = new Produto("Refactoring", 0.8, 150);

        Pedido pedido = new Pedido();
        pedido.adicionarProduto(livro1);
        pedido.adicionarProduto(livro2);

        System.out.println("===== PEDIDO =====");
        System.out.println("Peso total: " + pedido.getPesoTotal() + " kg");
        System.out.println("Valor total: R$ " + pedido.getValorTotal());

        CalculadoraFrete calculadora = new CalculadoraFrete();

        System.out.println("\n===== FRETES =====");

        // PAC
        try {
            double fretePAC = calculadora.calcular(pedido, new PACFrete());
            System.out.println("PAC: R$ " + fretePAC);
        } catch (IllegalArgumentException e) {
            System.out.println("PAC: " + e.getMessage());
        }

        // SEDEX
        try {
            double freteSEDEX = calculadora.calcular(pedido, new SEDEXFrete());
            System.out.println("SEDEX: R$ " + freteSEDEX);
        } catch (IllegalArgumentException e) {
            System.out.println("SEDEX: " + e.getMessage());
        }

        // Retirada
        double retirada = calculadora.calcular(pedido, new RetiradaLoja());
        System.out.println("Retirada na loja: R$ " + retirada);
    }
}