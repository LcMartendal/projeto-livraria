package org.example.questao03;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q03RemocoesPeloInicio {

    private static final int TESTES = 20;
    private static final int ELEMENTOS = 100000;

    public static void teste() {
        double somaTempoArrayList = 0;
        double somaTempoLinkedList = 0;
        int qtdeArrayListMaisRapido = 0;
        int qtdeLinkedListMaisRapido = 0;

        for (int t = 0; t < TESTES; t++) {

            //--- ArrayList ---
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i < ELEMENTOS; i++) arrayList.add(i);

            long inicioTempoExecucaoArrayList = System.nanoTime();

            while (!arrayList.isEmpty()) arrayList.remove(0);

            long fimTempoExecucaoArrayList = System.nanoTime();
            double tempoExecucaoArrayList = (fimTempoExecucaoArrayList - inicioTempoExecucaoArrayList) / 1_000_000.0;
//            System.out.println("Execução " + t + ": " + tempoExecucao);
            somaTempoArrayList += tempoExecucaoArrayList;

            //--- LinkedList ---
            LinkedList<Integer> linkedList = new LinkedList<>();

            for (int i = 0; i < ELEMENTOS; i++) linkedList.add(i);

            long inicioTempoExecucaoLinkedList = System.nanoTime();

            while (!linkedList.isEmpty()) linkedList.removeFirst();

            long fimTempoExecucaoLinkedList = System.nanoTime();
            double tempoExecucaoLinkedList = (fimTempoExecucaoLinkedList - inicioTempoExecucaoLinkedList) / 1_000_000.0;
//            System.out.println("Execução " + t + ": " + tempoExecucao);
            somaTempoLinkedList += tempoExecucaoLinkedList;

            if (tempoExecucaoLinkedList < tempoExecucaoArrayList) {
                qtdeLinkedListMaisRapido++;
            } else {
                qtdeArrayListMaisRapido++;
            }
        }

        System.out.println("*** QUESTÃO 03 EXERCICIO 02 ***");
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