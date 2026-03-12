package org.furb.frete;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.furb.model.Pedido;
import org.furb.model.Produto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes SEDEX")
class SedexFreteTest {

    @Test
    @DisplayName("Até 500g custa 12.5")
    void ate500g() {

        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro", 0.4, 100));

        double frete = new SEDEXFrete().calcularFrete(pedido);

        assertEquals(12.5, frete);
    }

    @Test
    @DisplayName("Até 1kg custa 20")
    void ate1kg() {

        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro", 0.9, 100));

        double frete = new SEDEXFrete().calcularFrete(pedido);

        assertEquals(20, frete);
    }

    @Test
    @DisplayName("Acima de 1kg aplica adicional")
    void acima1kg() {

        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro", 1.5, 100));

        double frete = new SEDEXFrete().calcularFrete(pedido);

        assertTrue(frete > 46.5);
    }
}