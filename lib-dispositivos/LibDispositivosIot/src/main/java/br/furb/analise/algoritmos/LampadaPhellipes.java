package br.furb.analise.algoritmos;

public class LampadaPhellipes {

    private boolean ligada;

    public void ligar() {
        ligada = true;
    }

    public void desligar() {
        ligada = false;
    }

    public boolean estaLigada() {
        return ligada;
    }
}