package org.example.services;

import org.example.funcionalidades.arCondicionado.FuncoesArCondicionado;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class ArCondicionadoServiceTest {

    @Test
    void deveLigarTodosArCondicionados() {
        FuncoesArCondicionado ar1 = mock(FuncoesArCondicionado.class);
        FuncoesArCondicionado ar2 = mock(FuncoesArCondicionado.class);

        ArCondicionadoService service = new ArCondicionadoService(List.of(ar1, ar2));

        service.ligar();

        verify(ar1).ligar();
        verify(ar2).ligar();
    }

    @Test
    void deveDesligarTodosArCondicionados() {
        FuncoesArCondicionado ar = mock(FuncoesArCondicionado.class);

        ArCondicionadoService service = new ArCondicionadoService(List.of(ar));

        service.desligar();

        verify(ar).desligar();
    }

    @Test
    void deveDefinirTemperaturaParaTodos() {
        FuncoesArCondicionado ar = mock(FuncoesArCondicionado.class);

        ArCondicionadoService service = new ArCondicionadoService(List.of(ar));

        service.definirTemperatura(22);

        verify(ar).definirTemperatura(22);
    }

    @Test
    void deveAumentarTemperatura() {
        FuncoesArCondicionado ar = mock(FuncoesArCondicionado.class);

        ArCondicionadoService service = new ArCondicionadoService(List.of(ar));

        service.aumentarTemperatura();

        verify(ar).aumentarTemperatura();
    }

    @Test
    void deveDiminuirTemperatura() {
        FuncoesArCondicionado ar = mock(FuncoesArCondicionado.class);

        ArCondicionadoService service = new ArCondicionadoService(List.of(ar));

        service.diminuirTemperatura();

        verify(ar).diminuirTemperatura();
    }
}