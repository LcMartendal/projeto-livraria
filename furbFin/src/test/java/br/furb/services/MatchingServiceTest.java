package br.furb.services;

import br.furb.models.Acao;
import br.furb.models.Ordem;
import br.furb.models.UsuarioInvestidor;
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
                new UsuarioInvestidor("A"),
                TipoOrdem.COMPRA,
                new BigDecimal("50")
        );

        Ordem venda = new Ordem(
                new UsuarioInvestidor("B"),
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
                new Ordem(new UsuarioInvestidor("A"), TipoOrdem.COMPRA, new BigDecimal("50"))
        );

        acao.adicionarVenda(
                new Ordem(new UsuarioInvestidor("B"), TipoOrdem.VENDA, new BigDecimal("60"))
        );

        service.processar(acao);

        assertTrue(acao.temCompras());
        assertTrue(acao.temVendas());
    }
}