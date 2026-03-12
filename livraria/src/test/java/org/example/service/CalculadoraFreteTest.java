package org.example.service;

import org.example.frete.TipoFrete;
import org.example.frete.PACFrete;
import org.example.frete.SEDEXFrete;
import org.example.frete.RetiradaLoja;
import org.example.model.Pedido;
import org.example.model.Produto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe CalculadoraFrete")
class CalculadoraFreteTest {

    private final CalculadoraFrete calculadora = new CalculadoraFrete();

    @Nested
    @DisplayName("Cálculo com strategies válidas")
    class CalculoValido {

        @Test
        @DisplayName("Deve calcular frete PAC corretamente")
        void deveCalcularPac() {

            Pedido pedido = new Pedido();
            pedido.adicionarProduto(new Produto("Livro", 0.8, 100));

            double frete = calculadora.calcular(pedido, new PACFrete());

            assertEquals(10, frete);
        }

        @Test
        @DisplayName("Deve calcular frete SEDEX corretamente")
        void deveCalcularSedex() {

            Pedido pedido = new Pedido();
            pedido.adicionarProduto(new Produto("Livro", 0.4, 100));

            double frete = calculadora.calcular(pedido, new SEDEXFrete());

            assertEquals(12.5, frete);
        }

        @Test
        @DisplayName("Deve calcular retirada na loja")
        void deveCalcularRetirada() {

            Pedido pedido = new Pedido();
            pedido.adicionarProduto(new Produto("Livro", 5, 100));

            double frete = calculadora.calcular(pedido, new RetiradaLoja());

            assertEquals(0, frete);
        }
    }

    @Nested
    @DisplayName("Cenários extremos")
    class CenariosExtremos {

        @Test
        @DisplayName("Pedido vazio ainda deve retornar frete válido")
        void pedidoVazio() {

            Pedido pedido = new Pedido();

            double frete = calculadora.calcular(pedido, new RetiradaLoja());

            assertEquals(0, frete);
        }

        @Test
        @DisplayName("Pedido com muitos produtos")
        void pedidoComMuitosProdutos() {

            Pedido pedido = new Pedido();

            for (int i = 0; i < 1000; i++) {
                pedido.adicionarProduto(new Produto("Livro", 0.01, 10));
            }

            double frete = calculadora.calcular(pedido, new SEDEXFrete());

            assertTrue(frete > 0);
        }

        @Test
        @DisplayName("Pedido com peso alto para SEDEX")
        void pesoMuitoAlto() {

            Pedido pedido = new Pedido();

            pedido.adicionarProduto(new Produto("Livro gigante", 50, 100));

            double frete = calculadora.calcular(pedido, new SEDEXFrete());

            assertTrue(frete > 46.5);
        }
    }

    @Nested
    @DisplayName("Testes de segurança e robustez")
    class TestesSeguranca {

        @Test
        @DisplayName("Não deve aceitar strategy nula")
        void strategyNula() {

            Pedido pedido = new Pedido();
            pedido.adicionarProduto(new Produto("Livro", 1, 100));

            assertThrows(NullPointerException.class,
                    () -> calculadora.calcular(pedido, null));
        }

        @Test
        @DisplayName("Não deve aceitar pedido nulo")
        void pedidoNulo() {

            assertThrows(NullPointerException.class,
                    () -> calculadora.calcular(null, new PACFrete()));
        }

        @Test
        @DisplayName("Strategy maliciosa não deve quebrar cálculo")
        void strategyMaliciosa() {

            Pedido pedido = new Pedido();
            pedido.adicionarProduto(new Produto("Livro", 1, 100));

            TipoFrete freteMalicioso = new TipoFrete() {
                @Override
                public double calcularFrete(Pedido pedido) {
                    return -999;
                }
            };

            double resultado = calculadora.calcular(pedido, freteMalicioso);

            assertEquals(-999, resultado);
        }
    }

    @Nested
    @DisplayName("Consistência do cálculo")
    class Consistencia {

        @Test
        @DisplayName("Mesmo pedido deve gerar mesmo frete")
        void calculoDeterministico() {

            Pedido pedido = new Pedido();
            pedido.adicionarProduto(new Produto("Livro", 0.8, 100));

            double frete1 = calculadora.calcular(pedido, new PACFrete());
            double frete2 = calculadora.calcular(pedido, new PACFrete());

            assertEquals(frete1, frete2);
        }

        @Test
        @DisplayName("Fretes diferentes devem gerar valores diferentes")
        void strategiesDiferentes() {

            Pedido pedido = new Pedido();
            pedido.adicionarProduto(new Produto("Livro", 0.8, 100));

            double pac = calculadora.calcular(pedido, new PACFrete());
            double sedex = calculadora.calcular(pedido, new SEDEXFrete());

            assertNotEquals(pac, sedex);
        }
    }
}