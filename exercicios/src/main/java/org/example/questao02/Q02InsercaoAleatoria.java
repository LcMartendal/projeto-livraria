package org.example.questao02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Q02InsercaoAleatoria {

    private static final int TESTES = 20;
    private static final int ELEMENTOS = 50000;

    public static void testarArrayList() {
        Random random = new Random();
        double soma = 0;

        for (int t = 0; t < TESTES; t++) {
            ArrayList<Integer> lista = new ArrayList<>();

            long inicio = System.nanoTime();

            for (int i = 0; i < ELEMENTOS; i++) {
                int index = random.nextInt(lista.size() + 1);
                lista.add(index, i);
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

            long inicio = System.nanoTime();

            for (int i = 0; i < ELEMENTOS; i++) {
                int index = random.nextInt(lista.size() + 1);
                lista.add(index, i);
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

            // --- ArrayList ---
            ArrayList<Integer> arrayList = new ArrayList<>();

            long inicioExecucaoArrayList = System.nanoTime();

            for (int i = 0; i < ELEMENTOS; i++) {
                int index = random.nextInt(arrayList.size() + 1);
                arrayList.add(index, i);
            }

            long fimExecucaoArrayList = System.nanoTime();

            double tempoExecucaoArrayList = (fimExecucaoArrayList - inicioExecucaoArrayList) / 1_000_000.0;
//            System.out.println("Execução " + t + ": " + tempoExecucaoArrayList);
            somaTempoArrayList += tempoExecucaoArrayList;

            // --- LinkedList ---
            LinkedList<Integer> linkedList = new LinkedList<>();

            long inicioExecucaoLinkedList = System.nanoTime();

            for (int i = 0; i < ELEMENTOS; i++) {
                int index = random.nextInt(linkedList.size() + 1);
                linkedList.add(index, i);
            }

            long fimExecucaoLinkedList = System.nanoTime();

            double tempoExecucaoLinkedList = (fimExecucaoLinkedList - inicioExecucaoLinkedList) / 1_000_000.0;
//            System.out.println("Execução " + t + ": " + tempoExecucaoLinkedList);
            somaTempoLinkedList += tempoExecucaoLinkedList;

            if (tempoExecucaoArrayList < tempoExecucaoLinkedList) {
                qtdeArrayListMaisRapido++;
            } else {
                qtdeLinkedListMaisRapido++;
            }
        }

        System.out.println("*** QUESTÃO 02 EXERCICIO 01 ***");
        System.out.println("----------------------------------");

        System.out.println("LinkedList média: " + (somaTempoLinkedList / TESTES) + " ms");
        System.out.println("ArrayList média: " + (somaTempoArrayList / TESTES) + " ms");

        if (somaTempoArrayList < somaTempoLinkedList) {
            System.out.println("Lista mais rápida: ArrayList");
            System.out.println("Quantidade de vezes que ArrayList foi mais rápido: " + qtdeArrayListMaisRapido);
        } else {
            System.out.println("Lista mais rápida: LinkedList" );
            System.out.println("Quantidade de vezes que LinkedList foi mais rápido: " + qtdeLinkedListMaisRapido);
        }
    }
}