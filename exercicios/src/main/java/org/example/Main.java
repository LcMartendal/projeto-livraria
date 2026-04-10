package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void q01Exer01ArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        List<Double> listaComADuracaoDeCadaExecucao = new ArrayList<>();

        System.out.println("------------------------------------------------------");
        System.out.println("Teste exercício 01 com ArrayList");

        for (int i=0; i<20; i++){

            long inicioMedicaoTempo = System.nanoTime();
            arrayList.add(arrayList.size(), 1);
            long fimMedicaoTempo = System.nanoTime();

            listaComADuracaoDeCadaExecucao.add(i, (fimMedicaoTempo - inicioMedicaoTempo / 1_000_000.0));
            System.out.println("Tempo por inserção: " + (fimMedicaoTempo - inicioMedicaoTempo / 1_000_000.0) + "ms");
        }

        double mediaDeTempo = listaComADuracaoDeCadaExecucao.stream().mapToDouble(Double::doubleValue).sum() / 20;

        System.out.println(" ");
        System.out.println("Medição tempo médio levado: " + mediaDeTempo + "ms");
        System.out.println("------------------------------------------------------");
    }

    public static void q01Exer01LinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        List<Double> listaComADuracaoDeCadaExecucao = new ArrayList<>();

        System.out.println("------------------------------------------------------");
        System.out.println("Teste exercício 01 com LinkedList");

        for (int i=0; i<20; i++){

            long inicioMedicaoTempo = System.nanoTime();
            linkedList.add(linkedList.size(), 1);
            long fimMedicaoTempo = System.nanoTime();

            listaComADuracaoDeCadaExecucao.add(i, (fimMedicaoTempo - inicioMedicaoTempo / 1_000_000.0));
            System.out.println("Tempo por inserção: " + (fimMedicaoTempo - inicioMedicaoTempo / 1_000_000.0) + "ms");
        }

        double mediaDeTempo = listaComADuracaoDeCadaExecucao.stream().mapToDouble(Double::doubleValue).sum() / 20;

        System.out.println(" ");
        System.out.println("Medição tempo médio levado: " + mediaDeTempo + "ms");
        System.out.println("------------------------------------------------------");
    }

    public static void q01Exer02ArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>(10);
        List<Double> listaComADuracaoDeCadaExecucao = new ArrayList<>();

        System.out.println("------------------------------------------------------");
        System.out.println("Teste exercício 02 com ArrayList");

        for (int i=0; i<20; i++){

            long inicioMedicaoTempo = System.nanoTime();
            arrayList.add(arrayList.size(), 1);
            long fimMedicaoTempo = System.nanoTime();

            listaComADuracaoDeCadaExecucao.add(i, (fimMedicaoTempo - inicioMedicaoTempo / 1_000_000.0));
            System.out.println("Tempo por inserção: " + (fimMedicaoTempo - inicioMedicaoTempo / 1_000_000.0) + "ms");
        }

        double mediaDeTempo = listaComADuracaoDeCadaExecucao.stream().mapToDouble(Double::doubleValue).sum() / 20;

        System.out.println(" ");
        System.out.println("Medição tempo médio levado: " + mediaDeTempo + "ms");
        System.out.println("------------------------------------------------------");
    }



    public static void main(String[] args) {

        q01Exer01LinkedList();
        q01Exer01ArrayList();

        q01Exer02ArrayList();
    }
}