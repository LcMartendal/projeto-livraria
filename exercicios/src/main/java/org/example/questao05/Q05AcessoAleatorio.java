package org.example.questao05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Q05AcessoAleatorio {

    private static final int TESTES = 20;
    private static final int ELEMENTOS = 100000;
    private static final int ACESSOS = 10000;

    public static void testarArrayList() {
        Random random = new Random();
        double soma = 0;

        for (int t = 0; t < TESTES; t++) {
            ArrayList<Integer> lista = new ArrayList<>();
            for (int i = 0; i < ELEMENTOS; i++) lista.add(i);

            long inicio = System.nanoTime();

            for (int i = 0; i < ACESSOS; i++) {
                lista.get(random.nextInt(ELEMENTOS));
            }

            long fim = System.nanoTime();
            double tempoExecucao = (fim - inicio) / 1_000_000.0;
            System.out.println("Execução " + t + ": " + tempoExecucao);
            soma += tempoExecucao;
        }

        System.out.println("ArrayList média: " + (soma / TESTES) + " ms");
    }

    public static void testarLinkedList() {
        Random random = new Random();
        double soma = 0;

        for (int t = 0; t < TESTES; t++) {
            LinkedList<Integer> lista = new LinkedList<>();
            for (int i = 0; i < ELEMENTOS; i++) lista.add(i);

            long inicio = System.nanoTime();

            for (int i = 0; i < ACESSOS; i++) {
                lista.get(random.nextInt(ELEMENTOS));
            }

            long fim = System.nanoTime();
            double tempoExecucao = (fim - inicio) / 1_000_000.0;
            System.out.println("Execução " + t + ": " + tempoExecucao);
            soma += tempoExecucao;
        }

        System.out.println("LinkedList média: " + (soma / TESTES) + " ms");
    }

    public static void teste() {
        Random random = new Random();
        double somaTempoArrayList = 0;
        double somaTempoLinkedList = 0;
        int qtdeArrayListMaisRapido = 0;
        int qtdeLinkedListMaisRapido = 0;

        for (int t = 0; t < TESTES; t++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < ELEMENTOS; i++) arrayList.add(i);

            long inicioExecucaoArrayList = System.nanoTime();

            for (int i = 0; i < ACESSOS; i++) {
                arrayList.get(random.nextInt(ELEMENTOS));
            }

            long fimExecucaoArrayList = System.nanoTime();
            double tempoExecucaoArrayList = (fimExecucaoArrayList - inicioExecucaoArrayList) / 1_000_000.0;
//            System.out.println("Execução " + t + ": " + tempoExecucaoArrayList);
            somaTempoArrayList += tempoExecucaoArrayList;

            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < ELEMENTOS; i++) linkedList.add(i);

            long inicioExecucaoLinkedList = System.nanoTime();

            for (int i = 0; i < ACESSOS; i++) {
                linkedList.get(random.nextInt(ELEMENTOS));
            }

            long fimExecucaoLinkedList = System.nanoTime();
            double tempoExecucaoLinkedList = (fimExecucaoLinkedList - inicioExecucaoLinkedList) / 1_000_000.0;
//            System.out.println("Execução " + t + ": " + tempoExecucaoLinkedList);
            somaTempoLinkedList += tempoExecucaoLinkedList;

            if (tempoExecucaoLinkedList < tempoExecucaoArrayList) {
                qtdeLinkedListMaisRapido++;
            } else {
                qtdeArrayListMaisRapido++;
            }
        }

        System.out.println("*** QUESTÃO 05 EXERCICIO 01 ***");
        System.out.println("----------------------------------");

        System.out.println("LinkedList média: " + (somaTempoLinkedList / TESTES) + " ms");
        System.out.println("ArrayList média: " + (somaTempoArrayList / TESTES) + " ms");

        if (somaTempoArrayList < somaTempoLinkedList) {
            System.out.println("Lista mais rápida: ArrayList");
            System.out.println("Quantidade de vezes que ArrayList foi mais rápido: " + qtdeArrayListMaisRapido);
        } else {
            System.out.println("Lista mais rápida: LinkedList");
            System.out.println("Quantidade de vezes que LinkedList foi mais rápido: " + qtdeLinkedListMaisRapido);
        }
    }
}