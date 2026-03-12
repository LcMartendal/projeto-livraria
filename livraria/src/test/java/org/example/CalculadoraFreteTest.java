package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.frete.PACFrete;
import org.example.frete.RetiradaLoja;
import org.example.frete.SEDEXFrete;
import org.example.model.Pedido;
import org.example.model.Produto;
import org.example.service.CalculadoraFrete;
import org.junit.jupiter.api.Test;

public class CalculadoraFreteTest {

    private Pedido criarPedido(double peso) {
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro", peso, 50));
        return pedido;
    }

    // TESTES PAC
    @Test
    void deveCalcularPACate1kg() {

        Pedido pedido = criarPedido(1);

        CalculadoraFrete calc = new CalculadoraFrete();
        double frete = calc.calcular(pedido, new PACFrete());

        assertEquals(10.0, frete);
    }

    @Test
    void deveCalcularPACate2kg() {

        Pedido pedido = criarPedido(2);

        CalculadoraFrete calc = new CalculadoraFrete();
        double frete = calc.calcular(pedido, new PACFrete());

        assertEquals(15.0, frete);
    }

    @Test
    void deveFalharPACacima2kg() {

        Pedido pedido = criarPedido(2.5);

        CalculadoraFrete calc = new CalculadoraFrete();

        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcular(pedido, new PACFrete());
        });
    }

    // TESTES SEDEX
    @Test
    void deveCalcularSEDEXate500g() {

        Pedido pedido = criarPedido(0.5);

        CalculadoraFrete calc = new CalculadoraFrete();
        double frete = calc.calcular(pedido, new SEDEXFrete());

        assertEquals(12.5, frete);
    }

    @Test
    void deveCalcularSEDEXate1kg() {

        Pedido pedido = criarPedido(1);

        CalculadoraFrete calc = new CalculadoraFrete();
        double frete = calc.calcular(pedido, new SEDEXFrete());

        assertEquals(20.0, frete);
    }

    @Test
    void deveCalcularSEDEXacima1kg() {

        Pedido pedido = criarPedido(1.2);

        CalculadoraFrete calc = new CalculadoraFrete();
        double frete = calc.calcular(pedido, new SEDEXFrete());

        assertEquals(49.5, frete);
    }

    // TESTE RETIRADA
    @Test
    void deveRetornarFreteZeroParaRetirada() {

        Pedido pedido = criarPedido(5);

        CalculadoraFrete calc = new CalculadoraFrete();
        double frete = calc.calcular(pedido, new RetiradaLoja());

        assertEquals(0, frete);
    }

    // TESTES PEDIDO
    @Test
    void deveCalcularPesoTotalPedido() {

        Pedido pedido = new Pedido();

        pedido.adicionarProduto(new Produto("Livro 1", 1, 50));
        pedido.adicionarProduto(new Produto("Livro 2", 2, 80));

        assertEquals(3, pedido.getPesoTotal());
    }

    @Test
    void deveCalcularValorTotalPedido() {

        Pedido pedido = new Pedido();

        pedido.adicionarProduto(new Produto("Livro 1", 1, 50));
        pedido.adicionarProduto(new Produto("Livro 2", 2, 80));

        assertEquals(130, pedido.getValorTotal());
    }

    @Test
    void deveCriarProdutoCorretamente() {

        Produto produto = new Produto("Clean Code", 1.2, 120);

        assertEquals("Clean Code", produto.getNome());
        assertEquals(1.2, produto.getPeso());
        assertEquals(120, produto.getPreco());
    }

    @Test
    void naoDevePermitirPesoZero() {
        assertThrows(IllegalArgumentException.class, () -> new Produto("Livro leve", 0, 10));
    }

    @Test
    void naoDevePermitirPrecoZero() {

        assertThrows(IllegalArgumentException.class, () -> new Produto("Livro leve", 1, 0));
    }

}