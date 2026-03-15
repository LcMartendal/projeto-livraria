package br.furb.models;

import br.furb.models.enums.TipoOrdem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da entidade Acao")
class AcaoTest {

    @Nested
    @DisplayName("Registro de ordens")
    class RegistroOrdens {

        @Test
        @DisplayName("Deve adicionar ordem de compra")
        void deveAdicionarCompra() {

            Acao acao = new Acao("PETR4", new BigDecimal("10"));

            Ordem ordem = new Ordem(
                    "Ana",
                    TipoOrdem.COMPRA,
                    new BigDecimal("20")
            );

            acao.adicionarCompra(ordem);

            assertTrue(acao.temCompras());
            assertEquals(ordem, acao.melhorCompra());
        }

        @Test
        @DisplayName("Deve adicionar ordem de venda")
        void deveAdicionarVenda() {

            Acao acao = new Acao("PETR4", new BigDecimal("10"));

            Ordem ordem = new Ordem(
                    "Ana",
                    TipoOrdem.VENDA,
                    new BigDecimal("20")
            );

            acao.adicionarVenda(ordem);

            assertTrue(acao.temVendas());
            assertEquals(ordem, acao.melhorVenda());
        }
    }

    @Nested
    @DisplayName("Remoção de ordens")
    class RemocaoOrdens {

        @Test
        void deveRemoverMelhorCompra() {

            Acao acao = new Acao("PETR4", new BigDecimal("10"));

            Ordem ordem = new Ordem(
                    "Ana",
                    TipoOrdem.COMPRA,
                    new BigDecimal("30")
            );

            acao.adicionarCompra(ordem);

            Ordem removida = acao.removerMelhorCompra();

            assertEquals(ordem, removida);
            assertFalse(acao.temCompras());
        }

        @Test
        void deveRemoverMelhorVenda() {

            Acao acao = new Acao("PETR4", new BigDecimal("10"));

            Ordem ordem = new Ordem(
                    "Ana",
                    TipoOrdem.VENDA,
                    new BigDecimal("30")
            );

            acao.adicionarVenda(ordem);

            Ordem removida = acao.removerMelhorVenda();

            assertEquals(ordem, removida);
            assertFalse(acao.temVendas());
        }
    }

    @Nested
    @DisplayName("Observadores")
    class Observadores {

        @Test
        void deveRegistrarInvestidor() {

            Acao acao = new Acao("PETR4", new BigDecimal("10"));
            UsuarioInvestidor investidor = new UsuarioInvestidor("Carlos");

            acao.registrarInvestidor(investidor);

            assertEquals(1, acao.getObservadores().size());
        }
    }
}