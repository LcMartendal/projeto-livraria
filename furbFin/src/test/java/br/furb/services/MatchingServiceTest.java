package br.furb.services;

import br.furb.models.Acao;
import br.furb.models.Ordem;
import br.furb.models.enums.TipoOrdem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes MatchingService")
class MatchingServiceTest {

    @Test
    void deveExecutarMatchQuandoValoresIguais() {

        MatchingService service = new MatchingService();

        Acao acao = new Acao("PETR4", new BigDecimal("10"));

        Ordem compra = new Ordem(
                "A",
                TipoOrdem.COMPRA,
                new BigDecimal("50")
        );

        Ordem venda = new Ordem(
                "B",
                TipoOrdem.VENDA,
                new BigDecimal("50")
        );

        acao.adicionarCompra(compra);
        acao.adicionarVenda(venda);

        service.processar(acao);

        assertFalse(acao.temCompras());
        assertFalse(acao.temVendas());
        assertEquals(new BigDecimal("50"), acao.getValorAtual());
    }

    @Test
    void naoDeveExecutarMatchQuandoValoresDiferentes() {

        MatchingService service = new MatchingService();

        Acao acao = new Acao("PETR4", new BigDecimal("10"));

        acao.adicionarCompra(
                new Ordem("A", TipoOrdem.COMPRA, new BigDecimal("50"))
        );

        acao.adicionarVenda(
                new Ordem("B", TipoOrdem.VENDA, new BigDecimal("60"))
        );

        service.processar(acao);

        assertTrue(acao.temCompras());
        assertTrue(acao.temVendas());
    }

    @Test
    @DisplayName("Deve executar múltiplos matches consecutivos")
    void deveExecutarMultiplosMatches() {

        MatchingService service = new MatchingService();

        Acao acao = new Acao("VALE3", new BigDecimal("10"));

        acao.adicionarCompra(new Ordem(
                "A",
                TipoOrdem.COMPRA,
                new BigDecimal("50")
        ));

        acao.adicionarCompra(new Ordem(
                "B",
                TipoOrdem.COMPRA,
                new BigDecimal("40")
        ));

        acao.adicionarVenda(new Ordem(
                "C",
                TipoOrdem.VENDA,
                new BigDecimal("50")
        ));

        acao.adicionarVenda(new Ordem(
               "D",
                TipoOrdem.VENDA,
                new BigDecimal("40")
        ));

        service.processar(acao);

        assertFalse(acao.temCompras());
        assertFalse(acao.temVendas());
        assertEquals(new BigDecimal("40"), acao.getValorAtual());
    }
}