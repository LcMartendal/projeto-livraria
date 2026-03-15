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

        UsuarioInvestidor investidor = new UsuarioInvestidor("João");

        Ordem ordem = new Ordem(
                investidor,
                TipoOrdem.COMPRA,
                new BigDecimal("50")
        );

        assertEquals(investidor, ordem.getInvestidor());
        assertEquals(TipoOrdem.COMPRA, ordem.getTipoOrdem());
        assertEquals(new BigDecimal("50"), ordem.getValor());
    }
}