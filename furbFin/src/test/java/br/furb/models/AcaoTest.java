package br.furb.models;

import br.furb.models.enums.TipoOrdem;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da entidade Acao")
class AcaoTest {

    private Acao acao;
    private UsuarioInvestidor investidor;

    @BeforeEach
    void setup() {
        acao = new Acao("PETR4", new BigDecimal("10"));
        investidor = new UsuarioInvestidor("Carlos");
    }

    @Nested
    @DisplayName("Registro de ordens")
    class RegistroOrdens {

        @Test
        void deveAdicionarOrdemCompra() {
            Ordem ordem = new Ordem(investidor, TipoOrdem.COMPRA, new BigDecimal("20"));
            acao.adicionarCompra(ordem);

            assertTrue(acao.melhorCompra().isPresent());
            assertEquals(ordem, acao.melhorCompra().get());
        }

        @Test
        void deveAdicionarOrdemVenda() {
            Ordem ordem = new Ordem(investidor, TipoOrdem.VENDA, new BigDecimal("20"));
            acao.adicionarVenda(ordem);

            assertTrue(acao.melhorVenda().isPresent());
            assertEquals(ordem, acao.melhorVenda().get());
        }
    }

    @Nested
    @DisplayName("Remoção de ordens")
    class RemocaoOrdens {

        @Test
        void deveRemoverMelhorCompra() {
            Ordem ordem = new Ordem(investidor, TipoOrdem.COMPRA, new BigDecimal("30"));
            acao.adicionarCompra(ordem);

            Ordem removida = acao.removerMelhorCompra();
            assertEquals(ordem, removida);
            assertTrue(acao.melhorCompra().isEmpty());
        }

        @Test
        void deveRemoverMelhorVenda() {
            Ordem ordem = new Ordem(investidor, TipoOrdem.VENDA, new BigDecimal("30"));
            acao.adicionarVenda(ordem);

            Ordem removida = acao.removerMelhorVenda();
            assertEquals(ordem, removida);
            assertTrue(acao.melhorVenda().isEmpty());
        }
    }

    @Nested
    @DisplayName("Observadores e notificações")
    class Observadores {

        @Test
        void deveRegistrarInvestidor() {
            acao.registrarInvestidor(investidor);
            assertEquals(1, acao.getObservadores().size());
        }

        @Test
        void deveNotificarInvestidorAoAtualizarValor() {
            acao.registrarInvestidor(investidor);

            assertDoesNotThrow(() ->
                    acao.atualizarValor(new BigDecimal("15"))
            );
            assertEquals(new BigDecimal("15"), acao.getValorAtual());
        }
    }
}