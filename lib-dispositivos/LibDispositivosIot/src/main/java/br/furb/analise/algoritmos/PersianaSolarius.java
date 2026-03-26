package br.furb.analise.algoritmos;

public class PersianaSolarius {

    private boolean aberta;

    public void abrir() {
        aberta = true;
    }

    public void fechar() {
        aberta = false;
    }

    public boolean estaAberta() {
        return aberta;
    }
}