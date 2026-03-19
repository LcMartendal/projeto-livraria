package br.furb.services;

import br.furb.models.Acao;
import br.furb.models.Ordem;
import br.furb.models.UsuarioInvestidor;
import br.furb.models.enums.TipoOrdem;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes BolsaDeValoresService")
class BolsaDeValoresServiceTest {

    private BolsaDeValoresService bolsa;
    private Acao acao;

    @BeforeEach
    void setup() {
        NotificacaoService notificacaoService = new NotificacaoService();
        MatchingService matchingService = new MatchingService(notificacaoService);
        bolsa = new BolsaDeValoresService(matchingService);

        acao = new Acao("PETR4", new BigDecimal("10"));
        bolsa.adicionarAcao(acao);
    }

    @Nested
    @DisplayName("Registro de ordens")
    class RegistroOrdem {

        @Test
        void deveRegistrarOrdemCompra() {
            Ordem ordem = new Ordem(
                    new UsuarioInvestidor("Ana"),
                    TipoOrdem.COMPRA,
                    new BigDecimal("20")
            );

            bolsa.registrarOrdem("PETR4", ordem);

            assertTrue(acao.melhorCompra().isPresent());
            assertEquals(ordem, acao.melhorCompra().get());
        }

        @Test
        void deveRegistrarOrdemVenda() {
            Ordem ordem = new Ordem(
                    new UsuarioInvestidor("Ana"),
                    TipoOrdem.VENDA,
                    new BigDecimal("25")
            );

            bolsa.registrarOrdem("PETR4", ordem);

            assertTrue(acao.melhorVenda().isPresent());
            assertEquals(ordem, acao.melhorVenda().get());
        }

        @Test
        void deveLancarErroQuandoAcaoNaoExiste() {
            Ordem ordem = new Ordem(
                    new UsuarioInvestidor("Ana"),
                    TipoOrdem.COMPRA,
                    new BigDecimal("20")
            );

            assertThrows(RuntimeException.class,
                    () -> bolsa.registrarOrdem("VALE3", ordem));
        }
    }
}