package org.example.services;

import org.example.funcionalidades.lampada.FuncoesLampada;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class LampadaServiceTest {

    @Test
    void deveLigarTodasLampadas() {
        FuncoesLampada lampada = mock(FuncoesLampada.class);

        LampadaService service = new LampadaService(List.of(lampada));

        service.ligar();

        verify(lampada).ligar();
    }

    @Test
    void deveDesligarTodasLampadas() {
        FuncoesLampada lampada = mock(FuncoesLampada.class);

        LampadaService service = new LampadaService(List.of(lampada));

        service.desligar();

        verify(lampada).desligar();
    }
}