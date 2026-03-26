package org.example.funcionalidades.arCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;

public class FuncoesArCondicionadoGellaKaza extends ArCondicionadoGellaKaza implements FuncoesArCondicionado {

    @Override
    public void ligar() {
        super.ativar();
    }

    @Override
    public void desligar() {
        super.desativar();
    }

    @Override
    public void aumentarTemperatura() {
        super.aumentarTemperatura();
    }

    @Override
    public void diminuirTemperatura() {
        super.diminuirTemperatura();
    }

    /**
     * GellaKaza não tem definirTemperatura().
     * Ajustamos incrementalmente a partir da temperatura atual.
     */
    @Override
    public void definirTemperatura(int temperatura) {
        int diff = temperatura - getTemperatura();

        if (diff > 0) {
            for (int i = 0; i < diff; i++) aumentarTemperatura();
        } else {
            for (int i = 0; i < -diff; i++) diminuirTemperatura();
        }
    }
}