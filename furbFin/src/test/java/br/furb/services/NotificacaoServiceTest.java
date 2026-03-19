package br.furb.services;

import br.furb.models.Acao;
import br.furb.models.UsuarioInvestidor;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Testes NotificacaoService")
class NotificacaoServiceTest {

    private Acao acao;
    private NotificacaoService service;

    @BeforeEach
    void setup() {
        acao = new Acao("PETR4", new BigDecimal("20"));
        service = new NotificacaoService();
    }

    @Test
    void deveNotificarInvestidoresRegistrados() {
        UsuarioInvestidor investidor1 = Mockito.mock(UsuarioInvestidor.class);
        UsuarioInvestidor investidor2 = Mockito.mock(UsuarioInvestidor.class);

        acao.registrarInvestidor(investidor1);
        acao.registrarInvestidor(investidor2);

        // atualiza valor → aciona notificação
        acao.atualizarValor(new BigDecimal("25"));

        Mockito.verify(investidor1).notificar("PETR4", new BigDecimal("25"));
        Mockito.verify(investidor2).notificar("PETR4", new BigDecimal("25"));
    }

    @Test
    void naoDeveFalharSemInvestidores() {
        assertDoesNotThrow(() -> acao.atualizarValor(new BigDecimal("30")));
    }
}