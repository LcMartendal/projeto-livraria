package org.example.services;

import org.example.funcionalidades.arCondicionado.FuncoesArCondicionadoGellaKaza;
import org.example.funcionalidades.arCondicionado.FuncoesArCondicionadoVentoBaumn;
import org.example.funcionalidades.lampada.FuncoesLampadaPhellipes;
import org.example.funcionalidades.lampada.FuncoesLampadaShoyuMi;
import org.example.funcionalidades.persiana.FuncoesPersianaNatLight;
import org.example.funcionalidades.persiana.FuncoesPersianaSolarius;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdaptersTest {

    @Test
    void lampadaShoyuMiLigarDesligar() {
        FuncoesLampadaShoyuMi lampada = new FuncoesLampadaShoyuMi();
        lampada.ligar();
        assertTrue(lampada.estaLigada());
        lampada.desligar();
        assertFalse(lampada.estaLigada());
    }

    @Test
    void lampadaPhellipesLigarDesligar() {
        FuncoesLampadaPhellipes lampada = new FuncoesLampadaPhellipes();
        lampada.ligar();
        assertTrue(lampada.estaLigada());
        lampada.desligar();
        assertFalse(lampada.estaLigada());
    }

    @Test
    void persianaSolariusAbrirFechar() throws Exception {
        FuncoesPersianaSolarius persiana = new FuncoesPersianaSolarius();
        persiana.abrir();
        assertTrue(persiana.estaAberta());
        persiana.fechar();
        assertFalse(persiana.estaAberta());
    }

    @Test
    void persianaNatLightAbrirFechar() throws Exception {
        FuncoesPersianaNatLight persiana = new FuncoesPersianaNatLight();
        persiana.abrir();
        assertTrue(persiana.estaAberta());
        persiana.fechar();
        assertFalse(persiana.estaAberta());
    }

    @Test
    void arVentoBaumnLigarDefinirTemperatura() {
        FuncoesArCondicionadoVentoBaumn ar = new FuncoesArCondicionadoVentoBaumn();
        ar.ligar();
        ar.definirTemperatura(22);
        assertEquals(22, ar.getTemperatura());
        ar.desligar();
        assertFalse(ar.estaLigado());
    }

    @Test
    void arGellaKazaLigarDefinirTemperatura() {
        FuncoesArCondicionadoGellaKaza ar = new FuncoesArCondicionadoGellaKaza();
        ar.ligar();
        assertTrue(ar.estaLigado());
        ar.definirTemperatura(30);
        assertEquals(30, ar.getTemperatura());
    }

    @Test
    void arGellaKazaAumentarDiminuirTemperatura() {
        FuncoesArCondicionadoGellaKaza ar = new FuncoesArCondicionadoGellaKaza();
        ar.ligar();
        int tempInicial = ar.getTemperatura(); // começa em 28
        ar.aumentarTemperatura();
        assertEquals(tempInicial + 1, ar.getTemperatura());
        ar.diminuirTemperatura();
        assertEquals(tempInicial, ar.getTemperatura());
    }
}