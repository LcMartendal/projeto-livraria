package org.example.frete;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.model.Pedido;
import org.example.model.Produto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes Retirada na Loja")
class RetiradaLojaTest {

    @Test
    @DisplayName("Retirada deve custar zero")
    void retiradaGratis() {

        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro", 5, 100));

        double frete = new RetiradaLoja().calcularFrete(pedido);

        assertEquals(0, frete);
    }
}