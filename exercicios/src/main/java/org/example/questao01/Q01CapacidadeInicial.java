package org.example.questao01;

import java.util.ArrayList;

public class Q01CapacidadeInicial {

    private static final int TESTES = 10;
    private static final int ELEMENTOS = 100000;

    private static Double testarCapacidadeinicial(int capacidade) {
        double soma = 0;

        for (int t = 0; t < TESTES; t++) {
            ArrayList<Integer> lista = new ArrayList<>(capacidade);

            long inicio = System.nanoTime();

            for (int i = 0; i < ELEMENTOS; i++) {
                lista.add(i);
            }

            long fim = System.nanoTime();
            soma += (fim - inicio) / 1_000_000.0;
        }

        return soma / TESTES;
    }

    public static void teste() {
        var somaListaComTamanhoIncial10 = testarCapacidadeinicial(10);
        var somaListaComTamanhoIncial1000 = testarCapacidadeinicial(1000);
        var somaListaComTamanhoIncial100000 = testarCapacidadeinicial(100000);

        System.out.println("*** QUESTÃO 01 EXERCICIO 02 ***");
        System.out.println("----------------------------------");
        System.out.println("Capacidade " + 10 + ": " + (somaListaComTamanhoIncial10 / TESTES) + " ms");
        System.out.println("---");
        System.out.println("Capacidade " + 1000 + ": " + (somaListaComTamanhoIncial1000 / TESTES) + " ms");
        System.out.println("---");
        System.out.println("Capacidade " + 100000 + ": " + (somaListaComTamanhoIncial100000 / TESTES) + " ms");

        if (somaListaComTamanhoIncial10 < somaListaComTamanhoIncial100000
                && somaListaComTamanhoIncial100000 > somaListaComTamanhoIncial1000) {
            System.out.println("ArrayList do tamanho inicial 10 é o mais rápido");
        } else if (somaListaComTamanhoIncial1000 < somaListaComTamanhoIncial100000
                && somaListaComTamanhoIncial10 > somaListaComTamanhoIncial100000) {
            System.out.println("ArrayList do tamanho inicial 1000 é o mais rápido");
        } else {
            System.out.println("ArrayList do tamanho inicial 100000 é o mais rápido");
        }
    }
}