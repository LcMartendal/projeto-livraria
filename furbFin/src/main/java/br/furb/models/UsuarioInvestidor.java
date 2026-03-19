package br.furb.models;

import br.furb.validators.UsuarioInvestidorValidator;

import java.math.BigDecimal;

public class UsuarioInvestidor {
    private final String nome;

    public UsuarioInvestidor(String nome) {
        UsuarioInvestidorValidator validator = new UsuarioInvestidorValidator();
        validator.validar(nome);

        this.nome = nome;
    }

    public void notificar(String acao, BigDecimal valor) {

        System.out.println(
                nome + " foi notificado: "
                        + acao + " agora vale " + valor
        );
    }

    public String getNome() {
        return nome;
    }
}
