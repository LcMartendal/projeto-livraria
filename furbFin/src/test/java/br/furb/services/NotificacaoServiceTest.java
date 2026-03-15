package br.furb.services;

import br.furb.models.Acao;
import br.furb.models.UsuarioInvestidor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NotificacaoServiceTest {

    @Test
    @DisplayName("Deve notificar todos investidores registrados")

    void deveNotificarInvestidores() {

        NotificacaoService service = new NotificacaoService();

        Acao acao = new Acao("PETR4", new BigDecimal("20"));

        UsuarioInvestidor investidor1 = Mockito.mock(UsuarioInvestidor.class);
        UsuarioInvestidor investidor2 = Mockito.mock(UsuarioInvestidor.class);

        acao.registrarInvestidor(investidor1);
        acao.registrarInvestidor(investidor2);

        service.notificar(acao);

        Mockito.verify(investidor1)
                .notificar("PETR4", new BigDecimal("20"));

        Mockito.verify(investidor2)
                .notificar("PETR4", new BigDecimal("20"));
    }

    @Test
    @DisplayName("Não deve falhar quando não há investidores registrados")
    void naoDeveFalharSemInvestidores() {

        NotificacaoService service = new NotificacaoService();

        Acao acao = new Acao("PETR4", new BigDecimal("20"));

        assertDoesNotThrow(() ->
                service.notificar(acao)
        );
    }
}