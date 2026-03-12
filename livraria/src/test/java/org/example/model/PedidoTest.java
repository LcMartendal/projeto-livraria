package org.example.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe Pedido")
class PedidoTest {

    @Nested
    @DisplayName("Operações do Pedido")
    class OperacoesPedido {

        @Test
        @DisplayName("Deve adicionar produto")
        void deveAdicionarProduto() {

            Pedido pedido = new Pedido();
            Produto p = new Produto("Livro", 1, 100);

            pedido.adicionarProduto(p);

            assertEquals(1, pedido.getProdutos().size());
        }

        @Test
        @DisplayName("Deve remover produto")
        void deveRemoverProduto() {

            Pedido pedido = new Pedido();
            Produto p = new Produto("Livro", 1, 100);

            pedido.adicionarProduto(p);
            pedido.removerProduto(p);

            assertEquals(0, pedido.getProdutos().size());
        }

        @Test
        @DisplayName("Calcula peso total corretamente")
        void deveCalcularPesoTotal() {

            Pedido pedido = new Pedido();

            pedido.adicionarProduto(new Produto("Livro1", 1, 100));
            pedido.adicionarProduto(new Produto("Livro2", 2, 200));

            assertEquals(3, pedido.getPesoTotal());
        }

        @Test
        @DisplayName("Calcula valor total corretamente")
        void deveCalcularValorTotal() {

            Pedido pedido = new Pedido();

            pedido.adicionarProduto(new Produto("Livro1", 1, 100));
            pedido.adicionarProduto(new Produto("Livro2", 1, 200));

            assertEquals(300, pedido.getValorTotal());
        }

        @Test
        @DisplayName("Pedido vazio deve retornar peso zero")
        void pedidoVazioPesoZero() {

            Pedido pedido = new Pedido();

            assertEquals(0, pedido.getPesoTotal());
        }
    }
}