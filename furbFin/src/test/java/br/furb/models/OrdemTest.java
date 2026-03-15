package br.furb.models;

import br.furb.models.enums.TipoOrdem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da entidade Ordem")
class OrdemTest {

    @Test
    void deveCriarOrdemCorretamente() {

        Ordem ordem = new Ordem(
                "joao",
                TipoOrdem.COMPRA,
                new BigDecimal("50")
        );

        assertEquals("joao", ordem.getInvestidor().getNome());
        assertEquals(TipoOrdem.COMPRA, ordem.getTipoOrdem());
        assertEquals(new BigDecimal("50"), ordem.getValor());
    }
}