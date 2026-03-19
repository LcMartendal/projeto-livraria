package br.furb.validators;

public class UsuarioInvestidorValidator {

    public void validar(String nome) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome é obrigatório");

        if (!nome.matches("^[A-Za-z ]+$")) throw new IllegalArgumentException("Nome inválido");
    }
}
