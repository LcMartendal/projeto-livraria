package org.example.validator;

public class PesoValidador implements Validador<Double> {
    @Override
    public void validar(Double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso não pode ser igual a 0 ou negativo");
        }

        if (peso == null) {
            throw new IllegalArgumentException("Peso é obrigatorio");
        }
    }
}
