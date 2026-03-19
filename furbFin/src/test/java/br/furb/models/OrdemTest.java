package br.furb.models;

import br.furb.models.enums.TipoOrdem;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da entidade Ordem")
class OrdemTest {

    @Test
    void deveCriarOrdemCorretamente() {
        var investidor = new UsuarioInvestidor("Joao");
        Ordem ordem = new Ordem(investidor, TipoOrdem.COMPRA, new BigDecimal("50"));

        assertEquals("Joao", ordem.getInvestidor().getNome());
        assertEquals(TipoOrdem.COMPRA, ordem.getTipoOrdem());
        assertEquals(new BigDecimal("50"), ordem.getValor());
    }
}