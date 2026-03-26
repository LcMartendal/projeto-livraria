package br.furb.analise.algoritmos;

public class ArCondicionadoGellaKaza {

    private boolean ligado;
    private int temperatura;

    public void ligar() {
        ligado = true;
    }

    public void desligar() {
        ligado = false;
    }

    public void definirTemperatura(int temperatura) {
        if (temperatura < 18 || temperatura > 28) {
            throw new IllegalArgumentException("Temperatura inválida");
        }
        this.temperatura = temperatura;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public boolean estaLigado() {
        return ligado;
    }
}