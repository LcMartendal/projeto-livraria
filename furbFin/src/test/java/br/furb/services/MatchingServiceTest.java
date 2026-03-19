package br.furb.services;

import br.furb.models.Acao;
import br.furb.models.Ordem;
import br.furb.models.UsuarioInvestidor;
import br.furb.models.enums.TipoOrdem;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes MatchingService")
class MatchingServiceTest {

    private MatchingService service;
    private Acao acao;
    private UsuarioInvestidor usuarioInvestidor01;
    private UsuarioInvestidor usuarioInvestidor02;
    private UsuarioInvestidor usuarioInvestidor03;
    private UsuarioInvestidor usuarioInvestidor04;

    @BeforeEach
    void setup() {
        service = new MatchingService(new NotificacaoService());
        acao = new Acao("PETR4", new BigDecimal("10"));

        usuarioInvestidor01 = new UsuarioInvestidor("A");
        usuarioInvestidor02 = new UsuarioInvestidor("B");
        usuarioInvestidor03 = new UsuarioInvestidor("C");
        usuarioInvestidor04 = new UsuarioInvestidor("D");
    }

    @Test
    void deveExecutarMatchQuandoValoresIguais() {
        acao.adicionarCompra(new Ordem(usuarioInvestidor01, TipoOrdem.COMPRA, new BigDecimal("50")));
        acao.adicionarVenda(new Ordem(usuarioInvestidor02, TipoOrdem.VENDA, new BigDecimal("50")));

        service.processar(acao);

        assertTrue(acao.melhorCompra().isEmpty());
        assertTrue(acao.melhorVenda().isEmpty());
        assertEquals(new BigDecimal("50"), acao.getValorAtual());
    }

    @Test
    void naoDeveExecutarMatchQuandoValoresDiferentes() {
        acao.adicionarCompra(new Ordem(usuarioInvestidor01, TipoOrdem.COMPRA, new BigDecimal("50")));
        acao.adicionarVenda(new Ordem(usuarioInvestidor02, TipoOrdem.VENDA, new BigDecimal("60")));

        service.processar(acao);

        assertTrue(acao.melhorCompra().isPresent());
        assertTrue(acao.melhorVenda().isPresent());
    }

    @Test
    void deveExecutarMultiplosMatches() {
        acao.adicionarCompra(new Ordem(usuarioInvestidor01, TipoOrdem.COMPRA, new BigDecimal("50")));
        acao.adicionarCompra(new Ordem(usuarioInvestidor02, TipoOrdem.COMPRA, new BigDecimal("40")));
        acao.adicionarVenda(new Ordem(usuarioInvestidor03, TipoOrdem.VENDA, new BigDecimal("50")));
        acao.adicionarVenda(new Ordem(usuarioInvestidor04, TipoOrdem.VENDA, new BigDecimal("40")));

        service.processar(acao);

        assertTrue(acao.melhorCompra().isPresent()); // 40 ainda existe
        assertTrue(acao.melhorVenda().isPresent()); // 50 ainda existe
        assertEquals(new BigDecimal("40"), acao.getValorAtual()); // último match foi 40
    }
}