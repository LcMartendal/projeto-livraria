package org.example;

import org.example.questao01.*;
import org.example.questao02.*;
import org.example.questao03.*;
import org.example.questao04.*;
import org.example.questao05.*;

public class Main {
    public static void main(String[] args) {

        // Questão 1
//        Q01InsercaoFinal.testarArrayList();
//        Q01InsercaoFinal.testarLinkedList();

        Q01InsercaoFinal.teste();
//
//        Q01CapacidadeInicial.testar(10);
//        Q01CapacidadeInicial.testar(1000);
//        Q01CapacidadeInicial.testar(100000);
        System.out.println("_______________________________________");
        Q01CapacidadeInicial.teste();
//
//        // Questão 2
//        Q02InsercaoAleatoria.testarArrayList();
//        Q02InsercaoAleatoria.testarLinkedList();
        System.out.println("_______________________________________");
        Q02InsercaoAleatoria.teste();
//
//        // Questão 3
//        Q03Remocoes.removerInicioArrayList();
//        Q03Remocoes.removerInicioLinkedList();
//        Q03Remocoes.removerFimArrayList();
//        Q03Remocoes.removerFimLinkedList();
        System.out.println("_______________________________________");
        Q03Remocoes.teste01();
        System.out.println("_______________________________________");
        Q03Remocoes.teste02();
//
//        // Questão 4
//        Q04RemocaoAleatoria.testarArrayList();
//        Q04RemocaoAleatoria.testarLinkedList();
        System.out.println("_______________________________________");
        Q04RemocaoAleatoria.teste();
//
//        // Questão 5
//        Q05AcessoAleatorio.testarArrayList();
//        Q05AcessoAleatorio.testarLinkedList();
        System.out.println("_______________________________________");
        Q05AcessoAleatorio.teste();
    }
}