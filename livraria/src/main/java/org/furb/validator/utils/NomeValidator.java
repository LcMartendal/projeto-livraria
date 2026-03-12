package org.furb.validator.utils;

public class NomeValidator {
    private static final String NOME_REGEX = "^[\\p{L} .'-]+$";

    public void validar(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        String trimmed = nome.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        if (!trimmed.matches(NOME_REGEX)) {
            throw new IllegalArgumentException("Nome contém caracteres inválidos");
        }
    }
}
