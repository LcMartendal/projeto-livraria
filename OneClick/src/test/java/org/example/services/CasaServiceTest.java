package org.example.services;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CasaServiceTest {

    @Test
    void deveExecutarModoSono() {
        PersianaService persiana = mock(PersianaService.class);
        LampadaService lampada = mock(LampadaService.class);
        ArCondicionadoService ar = mock(ArCondicionadoService.class);

        CasaService casa = new CasaService(persiana, lampada, ar);

        casa.modoSono();

        verify(lampada).desligar();
        verify(ar).desligar();
        verify(persiana).fechar();
    }

    @Test
    void deveExecutarModoTrabalho() {
        PersianaService persiana = mock(PersianaService.class);
        LampadaService lampada = mock(LampadaService.class);
        ArCondicionadoService ar = mock(ArCondicionadoService.class);

        CasaService casa = new CasaService(persiana, lampada, ar);

        casa.modoTrabalho();

        verify(lampada).ligar();
        verify(ar).ligar();
        verify(ar).definirTemperatura(25);
        verify(persiana).abrir();
    }
}