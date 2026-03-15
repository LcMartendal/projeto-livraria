package br.furb.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do UsuarioInvestidor")
class UsuarioInvestidorTest {

    @Test
    void deveCriarUsuarioComNome() {

        UsuarioInvestidor usuario = new UsuarioInvestidor("Maria");

        assertEquals("Maria", usuario.getNome());
    }

    @Test
    void naoDeveLancarErroAoNotificar() {

        UsuarioInvestidor usuario = new UsuarioInvestidor("Maria");

        assertDoesNotThrow(() ->
                usuario.notificar("PETR4", new BigDecimal("20"))
        );
    }
}