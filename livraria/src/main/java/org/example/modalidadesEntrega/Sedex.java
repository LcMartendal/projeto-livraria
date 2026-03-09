package org.example.modalidadesEntrega;

public class Sedex implements FormaDeCalculo{

    @Override
    public double calculoDeCobrancaDaEntrega(double pesoTotalPedido) {
        if (pesoTotalPedido < 0.5) { return 12.5; }

        if (pesoTotalPedido < 1) { return 20; }

        return calculoDeAdicionalNaCobrancaDeEntrega(pesoTotalPedido);
    }

    private double calculoDeAdicionalNaCobrancaDeEntrega(double peso) {
        double pesoAdicional = peso - 1;
        double valorAdicional = (pesoAdicional / 100) * 1.5;

        return 46.5 + valorAdicional;
    }
}
