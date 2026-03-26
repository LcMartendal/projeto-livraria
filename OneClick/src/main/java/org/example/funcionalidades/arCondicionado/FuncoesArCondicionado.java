package org.example.funcionalidades.arCondicionado;

public interface FuncoesArCondicionado {
    void ligar();
    void desligar();
    void aumentarTemperatura();
    void diminuirTemperatura();
    void definirTemperatura(int temperatura);
    boolean estaLigado();
    int getTemperatura();
}
