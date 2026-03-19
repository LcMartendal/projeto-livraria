package br.furb.models;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do UsuarioInvestidor")
class UsuarioInvestidorTest {

    private UsuarioInvestidor usuario;

    @BeforeEach
    void setup() {
        usuario = new UsuarioInvestidor("Maria");
    }

    @Test
    void deveCriarUsuarioComNome() {
        assertEquals("Maria", usuario.getNome());
    }

    @Test
    void naoDeveLancarErroAoNotificar() {
        assertDoesNotThrow(() -> usuario.notificar("PETR4", new BigDecimal("20")));
    }
}