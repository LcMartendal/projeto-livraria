package org.example.funcionalidades.lampada;

import br.furb.analise.algoritmos.LampadaPhellipes;

/**
 * Phellipes usa setIntensidade(int): 0 = desligado, 100 = máximo.
 */
public class FuncoesLampadaPhellipes extends LampadaPhellipes implements FuncoesLampada {

    @Override
    public void ligar() {
        try {
            super.setIntensidade(100);
        } catch (Exception e) { }
    }

    @Override
    public void desligar() {
        try {
            super.setIntensidade(0);
        } catch (Exception e) { }
    }

    @Override
    public boolean estaLigada() {
        return super.getIntensidade() > 0;
    }
}