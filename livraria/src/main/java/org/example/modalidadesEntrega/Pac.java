package org.example.modalidadesEntrega;

public class Pac implements FormaDeCalculo {

    @Override
    public double calculoDeCobrancaDaEntrega(double pesoTotalPedido) {
        if (pesoTotalPedido < 1) { return 10; }

        if (pesoTotalPedido < 2) { return 15; }

        throw new RuntimeException("Tipo de entrega não aceito");
    }
}
