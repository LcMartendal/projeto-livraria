package br.furb.analise.algoritmos;

public class ArCondicionadoVentoBaumn {

    private boolean ligado;
    private int temperatura;

    public void ligar() {
        ligado = true;
    }

    public void desligar() {
        ligado = false;
    }

    public void definirTemperatura(int temperatura) {
        if (temperatura < 16 || temperatura > 30) {
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
