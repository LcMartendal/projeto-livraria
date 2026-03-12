package org.example.validator;

public class PrecoValidator implements Validador<Double> {
    @Override
    public void validar(Double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço não pode ser igual ou menor que 0");
        }

        if (preco == null) {
            throw new IllegalArgumentException("Preço é obrigatorio");
        }
    }
}
