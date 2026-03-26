package org.example.services;

import org.example.funcionalidades.persiana.FuncoesPersiana;
import org.example.funcionalidades.persiana.FuncoesPersianaNatLight;
import org.example.funcionalidades.persiana.FuncoesPersianaSolarius;

import java.util.List;

public class PersianaService {

    private final List<FuncoesPersiana> persianas;

    public PersianaService() {
        this.persianas = List.of(new FuncoesPersianaSolarius(), new FuncoesPersianaNatLight());
    }

    public PersianaService(List<FuncoesPersiana> persianas) {
        this.persianas = persianas;
    }

    public void abrir() {
        for (FuncoesPersiana persiana : persianas) {
            try {
                persiana.abrir();
            } catch (Exception e) {
                System.err.println("Erro ao abrir persiana: " + e.getMessage());
            }
        }
    }

    public void fechar() {
        for (FuncoesPersiana persiana : persianas) {
            try {
                persiana.fechar();
            } catch (Exception e) {
                System.err.println("Erro ao fechar persiana: " + e.getMessage());
            }
        }
    }
}