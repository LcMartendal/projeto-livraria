package org.example.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe Produto")
class ProdutoTest {

    @Nested
    @DisplayName("Criação de Produto")
    class CriacaoProduto {

        @Test
        @DisplayName("Deve criar produto válido")
        void deveCriarProdutoValido() {
            Produto p = new Produto("Livro", 1.2, 100);

            assertEquals(1.2, p.getPeso());
            assertEquals(100, p.getPreco());
        }

        @Test
        @DisplayName("Não deve aceitar peso negativo")
        void naoDeveAceitarPesoNegativo() {
            assertThrows(IllegalArgumentException.class,
                    () -> new Produto("Livro", -1, 100));
        }

        @Test
        @DisplayName("Não deve aceitar preço negativo")
        void naoDeveAceitarPrecoNegativo() {
            assertThrows(IllegalArgumentException.class,
                    () -> new Produto("Livro", 1, -100));
        }

        @Test
        @DisplayName("Não deve aceitar peso zero")
        void naoDeveAceitarPesoZero() {
            assertThrows(IllegalArgumentException.class,
                    () -> new Produto("Livro", 0, 100));
        }

        @Test
        @DisplayName("Não deve aceitar preço zero")
        void naoDeveAceitarPrecoZero() {
            assertThrows(IllegalArgumentException.class,
                    () -> new Produto("Livro", 1, 0));
        }

        @Test
        @DisplayName("Testa valores extremos")
        void deveAceitarValoresGrandes() {
            Produto p = new Produto("Livro", 9999, 999999);

            assertNotNull(p);
        }
    }
}