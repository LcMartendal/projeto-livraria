package org.example.funcionalidades.arCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;

public class FuncoesArCondicionadoVentoBaumn extends ArCondicionadoVentoBaumn implements FuncoesArCondicionado {

    @Override
    public void ligar() {
        super.ligar();
    }

    @Override
    public void desligar() {
        super.desligar();
    }

    /**
     * VentoBaumn não tem aumentarTemperatura() na lib.
     * Incrementamos via definirTemperatura.
     */
    @Override
    public void aumentarTemperatura() {
        try {
            super.definirTemperatura(getTemperatura() + 1);
        } catch (Exception e) {
            // Limite máximo atingido
        }
    }

    @Override
    public void diminuirTemperatura() {
        try {
            super.definirTemperatura(getTemperatura() - 1);
        } catch (Exception e) {
            // Limite mínimo atingido
        }
    }

    @Override
    public void definirTemperatura(int temperatura) {
        if (temperatura >= 15 && temperatura <= 35) {
            super.definirTemperatura(temperatura);
        }
    }


    //NÃO IMPLEMENTADO NA LIB
    @Override
    public boolean estaLigado() {
        return super.estaLigado();
    }
}