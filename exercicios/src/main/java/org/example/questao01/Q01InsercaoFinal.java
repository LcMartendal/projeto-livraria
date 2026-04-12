package org.example.questao01;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q01InsercaoFinal {

    private static final int TESTES = 20;
    private static final int ELEMENTOS = 100000;

    public static void testarArrayList() {
        double soma = 0;

        for (int t = 0; t < TESTES; t++) {
            ArrayList<Integer> lista = new ArrayList<>();

            long inicio = System.nanoTime();

            for (int i = 0; i < ELEMENTOS; i++) {
                lista.add(i);
            }

            long fim = System.nanoTime();
            double tempoExecucao = (fim - inicio) / 1_000_000.0;
            System.out.println("Execução " + (t+1) + ": " + tempoExecucao);
            soma += tempoExecucao;
        }

        System.out.println("Tempo médio de preenchimento do ArrayList : " + (soma / TESTES) + " ms");
    }

    public static void testarLinkedList() {
        double soma = 0;

        for (int t = 0; t < TESTES; t++) {
            LinkedList<Integer> lista = new LinkedList<>();

            long inicio = System.nanoTime();

            for (int i = 0; i < ELEMENTOS; i++) {
                lista.add(i);
            }

            long fim = System.nanoTime();
            double tempoExecucao = (fim - inicio) / 1_000_000.0;
            System.out.println("Execução " + (t+1) + ": " + tempoExecucao);
            soma += tempoExecucao;
        }

        System.out.println("Tempo médio de preenchimento do LinkedList: " + (soma / TESTES) + " ms");
    }

    public static void teste() {
        double somaTempoArrayList = 0;
        double somaTempoLinkedList = 0;
        int qtdeArrayListMaisRapido = 0;
        int qtdeLinkedListMaisRapido = 0;

        for (int t = 0; t < TESTES; t++) {
            ArrayList<Integer> arrayList = new ArrayList<>();

            long inicioTempoExecucaoArrayList = System.nanoTime();

            for (int i = 0; i < ELEMENTOS; i++) {
                arrayList.add(i);
            }

            long fimTempoExecucaoArrayList = System.nanoTime();
            double tempoExecucaoArrayList = (fimTempoExecucaoArrayList - inicioTempoExecucaoArrayList) / 1_000_000.0;
//            System.out.println("Execução " + (t+1) + ": " + tempoExecucaoArrayList);
            somaTempoArrayList += tempoExecucaoArrayList;


            LinkedList<Integer> linkedList = new LinkedList<>();

            long inicioTempoExecucaoLinkedList = System.nanoTime();

            for (int i = 0; i < ELEMENTOS; i++) {
                linkedList.add(i);
            }

            long fimTempoExecucaoLinkedList = System.nanoTime();
            double tempoExecucaoLinkedList = (fimTempoExecucaoLinkedList - inicioTempoExecucaoLinkedList) / 1_000_000.0;
//            System.out.println("Execução " + (t+1) + ": " + tempoExecucaoLinkedList);
            somaTempoLinkedList += tempoExecucaoLinkedList;

            if (tempoExecucaoLinkedList < tempoExecucaoArrayList) {
                qtdeLinkedListMaisRapido++;
            } else {
                qtdeArrayListMaisRapido++;
            }
        }

        System.out.println("*** QUESTÃO 01 EXERCICIO 01 ***");
        System.out.println("----------------------------------");

        System.out.println("Tempo médio de preenchimento do ArrayList : " + (somaTempoArrayList / TESTES) + " ms");
        System.out.println("Tempo médio de preenchimento do LinkedList: " + (somaTempoLinkedList / TESTES) + " ms");

        if (somaTempoArrayList < somaTempoLinkedList) {
            System.out.println("Lista mais rápida: ArrayList");
        } else {
            System.out.println("Lista mais rápida: LinkedList" );
        }

        System.out.println("Quantidade de vezes que ArrayList foi mais rápido: " + qtdeArrayListMaisRapido);
        System.out.println("Quantidade de vezes que LinkedList foi mais rápido: " + qtdeLinkedListMaisRapido);
    }
}