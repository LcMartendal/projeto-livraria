package org.example.frete;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.model.Pedido;
import org.example.model.Produto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes PAC")
class PACFreteTest {

    @Test
    @DisplayName("Frete até 1kg deve custar 10")
    void freteAte1Kg() {

        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro", 0.8, 100));

        double frete = new PACFrete().calcularFrete(pedido);

        assertEquals(10, frete);
    }

    @Test
    @DisplayName("Frete até 2kg deve custar 15")
    void freteAte2Kg() {

        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro", 1.5, 100));

        double frete = new PACFrete().calcularFrete(pedido);

        assertEquals(15, frete);
    }

    @Test
    @DisplayName("PAC deve rejeitar peso acima de 2kg")
    void pacNaoAceitaMais2kg() {

        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro", 3, 100));

        assertThrows(IllegalArgumentException.class,
                () -> new PACFrete().calcularFrete(pedido));
    }
}