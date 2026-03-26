package org.example.services;

import org.example.funcionalidades.persiana.FuncoesPersiana;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class PersianaServiceTest {

    @Test
    void deveAbrirTodasPersianas() throws Exception {
        FuncoesPersiana persiana = mock(FuncoesPersiana.class);

        PersianaService service = new PersianaService(List.of(persiana));

        service.abrir();

        verify(persiana).abrir();
    }

    @Test
    void deveFecharTodasPersianas() throws Exception {
        FuncoesPersiana persiana = mock(FuncoesPersiana.class);

        PersianaService service = new PersianaService(List.of(persiana));

        service.fechar();

        verify(persiana).fechar();
    }

    @Test
    void naoDevePararQuandoUmaPersianaFalharAoAbrir() throws Exception {
        FuncoesPersiana p1 = mock(FuncoesPersiana.class);
        FuncoesPersiana p2 = mock(FuncoesPersiana.class);

        doThrow(new RuntimeException("erro")).when(p1).abrir();

        PersianaService service = new PersianaService(List.of(p1, p2));

        service.abrir();

        verify(p1).abrir();
        verify(p2).abrir();
    }
}