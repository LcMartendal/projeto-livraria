package org.example.questao01;

import java.util.ArrayList;

public class Q01CapacidadeInicial {

    private static final int TESTES = 10;
    private static final int ELEMENTOS = 100000;

    public static void testar(int capacidade) {
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

        System.out.println("*** QUESTÃO 01 EXERCICIO 02 ***");
        System.out.println("----------------------------------");
        System.out.println("Capacidade " + capacidade + ": " + (soma / TESTES) + " ms");
    }

    public static void teste() {
        double somaListaComTamanhoIncial10 = 0;
        double somaListaComTamanhoIncial1000 = 0;
        double somaListaComTamanhoIncial1000000 = 0;

        for (int t = 0; t < TESTES; t++) {
            // --- Lista Com Tamanho Inicial 10
            ArrayList<Integer> lista10 = new ArrayList<>(10);

            long inicioTempoExecucaoLista10 = System.nanoTime();

            for (int i = 0; i < ELEMENTOS; i++) {
                lista10.add(i);
            }

            long fimTempoExecucaoLista10 = System.nanoTime();
            somaListaComTamanhoIncial10 += (fimTempoExecucaoLista10 - inicioTempoExecucaoLista10) / 1_000_000.0;

            // --- Lista Com Tamanho Inicial 1000
            ArrayList<Integer> lista1000 = new ArrayList<>(1000);

            long inicioTempoExecucaoLista1000 = System.nanoTime();

            for (int i = 0; i < ELEMENTOS; i++) {
                lista1000.add(i);
            }

            long fimTempoExecucaoLista1000 = System.nanoTime();
            somaListaComTamanhoIncial1000 += (fimTempoExecucaoLista1000 - inicioTempoExecucaoLista1000) / 1_000_000.0;

            // --- Lista Com Tamanho Inicial 1000000
            ArrayList<Integer> lista1000000 = new ArrayList<>(1000000);

            long inicioTempoExecucaoLista1000000 = System.nanoTime();

            for (int i = 0; i < ELEMENTOS; i++) {
                lista1000000.add(i);
            }

            long fimTempoExecucaoLista1000000 = System.nanoTime();
            somaListaComTamanhoIncial1000000 += (fimTempoExecucaoLista1000000 - inicioTempoExecucaoLista1000000) / 1_000_000.0;
        }

        System.out.println("*** QUESTÃO 01 EXERCICIO 02 ***");
        System.out.println("----------------------------------");
        System.out.println("Capacidade " + 10 + ": " + (somaListaComTamanhoIncial10 / TESTES) + " ms");
        System.out.println("---");
        System.out.println("Capacidade " + 1000 + ": " + (somaListaComTamanhoIncial1000 / TESTES) + " ms");
        System.out.println("---");
        System.out.println("Capacidade " + 1000000 + ": " + (somaListaComTamanhoIncial1000000 / TESTES) + " ms");

        if (somaListaComTamanhoIncial10 < somaListaComTamanhoIncial1000000
                && somaListaComTamanhoIncial1000 > somaListaComTamanhoIncial1000000) {
            System.out.println("ArrayList do tamanho inicial 10 é o mais rápido");
        } else if (somaListaComTamanhoIncial1000 < somaListaComTamanhoIncial1000000
                && somaListaComTamanhoIncial10 > somaListaComTamanhoIncial1000000) {
            System.out.println("ArrayList do tamanho inicial 1000 é o mais rápido");
        } else {
            System.out.println("ArrayList do tamanho inicial 1000000 é o mais rápido");
        }
    }
}