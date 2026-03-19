package br.furb.validators;

import java.math.BigDecimal;

public class AcaoValidator {

    public void validar(String nome, BigDecimal valor) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome não pode ser vazio");

        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Valor não pode ser negativo");
    }
}
