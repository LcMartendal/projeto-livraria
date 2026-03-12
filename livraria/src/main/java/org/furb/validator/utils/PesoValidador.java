package org.furb.validator.utils;

public class PesoValidador  {
    public void validar(Double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso não pode ser igual a 0 ou negativo");
        }

        if (peso.equals(null)) {
            throw new IllegalArgumentException("Peso é obrigatorio");
        }
    }
}
