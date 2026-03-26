package org.example.services;

import org.example.funcionalidades.arCondicionado.FuncoesArCondicionado;
import org.example.funcionalidades.arCondicionado.FuncoesArCondicionadoGellaKaza;
import org.example.funcionalidades.arCondicionado.FuncoesArCondicionadoVentoBaumn;

import java.util.List;

public class ArCondicionadoService {

    private final List<FuncoesArCondicionado> arCondicionados;

    public ArCondicionadoService() {
        this.arCondicionados = List.of(
                new FuncoesArCondicionadoVentoBaumn(),
                new FuncoesArCondicionadoGellaKaza()
        );
    }

    public ArCondicionadoService(List<FuncoesArCondicionado> arCondicionados) {
        this.arCondicionados = arCondicionados;
    }

    public void ligar() {
        arCondicionados.forEach(FuncoesArCondicionado::ligar);
    }

    public void desligar() {
        arCondicionados.forEach(FuncoesArCondicionado::desligar);
    }

    public void aumentarTemperatura() {
        arCondicionados.forEach(FuncoesArCondicionado::aumentarTemperatura);
    }

    public void diminuirTemperatura() {
        arCondicionados.forEach(FuncoesArCondicionado::diminuirTemperatura);
    }

    public void definirTemperatura(int temperatura) {
        arCondicionados.forEach(ar -> ar.definirTemperatura(temperatura));
    }
}
