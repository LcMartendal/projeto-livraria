package br.furb.models;

import java.math.BigDecimal;

public class UsuarioInvestidor {
    private String nome;

    public UsuarioInvestidor(String nome) {
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
