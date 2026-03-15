package br.furb.services;

import br.furb.models.Acao;
import br.furb.models.Ordem;
import br.furb.models.UsuarioInvestidor;
import br.furb.models.enums.TipoOrdem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes BolsaDeValoresService")
class BolsaDeValoresServiceTest {

    @Nested
    class RegistroOrdem {

        @Test
        void deveRegistrarOrdemCompra() {

            BolsaDeValoresService bolsa = new BolsaDeValoresService();

            Acao acao = new Acao("PETR4", new BigDecimal("10"));
            bolsa.adicionarAcao(acao);

            Ordem ordem = new Ordem(
                    "Ana",
                    TipoOrdem.COMPRA,
                    new BigDecimal("20")
            );

            bolsa.registrarOrdem("PETR4", ordem);

            assertTrue(acao.temCompras());
        }

        @Test
        void deveLancarErroQuandoAcaoNaoExiste() {

            BolsaDeValoresService bolsa = new BolsaDeValoresService();

            Ordem ordem = new Ordem(
                    "Ana",
                    TipoOrdem.COMPRA,
                    new BigDecimal("20")
            );

            assertThrows(RuntimeException.class,
                    () -> bolsa.registrarOrdem("PETR4", ordem));
        }
    }
}