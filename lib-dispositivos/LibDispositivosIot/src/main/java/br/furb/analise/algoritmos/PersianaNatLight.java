package br.furb.analise.algoritmos;

public class PersianaNatLight {

    private int abertura; // 0 a 100

    public void abrir() {
        abertura = 100;
    }

    public void fechar() {
        abertura = 0;
    }

    public void definirAbertura(int abertura) {
        if (abertura < 0 || abertura > 100) {
            throw new IllegalArgumentException("Abertura inválida");
        }
        this.abertura = abertura;
    }

    public int getAbertura() {
        return abertura;
    }
}