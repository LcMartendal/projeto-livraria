package org.example.services;

import org.example.funcionalidades.lampada.FuncoesLampada;
import org.example.funcionalidades.lampada.FuncoesLampadaPhellipes;
import org.example.funcionalidades.lampada.FuncoesLampadaShoyuMi;

import java.util.List;

public class LampadaService {

    private final List<FuncoesLampada> lampadas;

    public LampadaService() {
        this.lampadas = List.of(new FuncoesLampadaShoyuMi(), new FuncoesLampadaPhellipes());
    }

    public LampadaService(List<FuncoesLampada> lampadas) {
        this.lampadas = lampadas;
    }

    public void ligar() {
        lampadas.forEach(FuncoesLampada::ligar);
    }

    public void desligar() {
        lampadas.forEach(FuncoesLampada::desligar);
    }
}