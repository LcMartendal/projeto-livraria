package br.furb.analise.algoritmos;

public class LampadaShoyuMi {

    private boolean ligada;
    private int intensidade;

    public void ligar() {
        ligada = true;
    }

    public void desligar() {
        ligada = false;
    }

    public void definirIntensidade(int intensidade) {
        if (intensidade < 0 || intensidade > 100) {
            throw new IllegalArgumentException("Intensidade inválida");
        }
        this.intensidade = intensidade;
    }

    public int getIntensidade() {
        return intensidade;
    }

    public boolean estaLigada() {
        return ligada;
    }
}