package org.furb.validator.utils;

public class PrecoValidator {
    public void validar(Double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço não pode ser igual ou menor que 0");
        }

        if (preco.equals(null)) {
            throw new IllegalArgumentException("Preço é obrigatorio");
        }
    }
}
