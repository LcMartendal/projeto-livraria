package org.furb.validator.utils;

public class NomeValidator {
    private static final String NOME_REGEX = "^[\\p{L}\\p{N} .'-]+$";

    public void validar(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        if (Character.isWhitespace(nome.charAt(0))) {
            throw new IllegalArgumentException("Nome não pode começar com espaço");
        }

        if (!nome.matches(NOME_REGEX)) {
            throw new IllegalArgumentException("Nome contém caracteres inválidos");
        }

        if (!nome.matches(".*[\\p{L}\\p{N}].*")) {
            throw new IllegalArgumentException("Nome deve conter pelo menos uma letra ou número");
        }
    }
}
