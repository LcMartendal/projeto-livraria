package org.example.funcionalidades.arCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;

public class FuncoesArCondicionadoGellaKaza extends ArCondicionadoGellaKaza implements FuncoesArCondicionado {

    @Override
    public void ligar() {
        super.ativar(); // GellaKaza usa ativar(), não ligar()
    }

    @Override
    public void desligar() {
        super.desativar(); // GellaKaza usa desativar(), não desligar()
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
        if (!estaLigado()) {
            ligar();
        }
        int atual = getTemperatura();
        while (atual < temperatura) {
            super.aumentarTemperatura();
            atual++;
        }
        while (atual > temperatura) {
            super.diminuirTemperatura();
            atual--;
        }
    }
}