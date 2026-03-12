package org.furb.validator;

import org.furb.validator.utils.NomeValidator;
import org.furb.validator.utils.PesoValidador;
import org.furb.validator.utils.PrecoValidator;

public class ProdutoValidator {
    private final NomeValidator nomeValidator;
    private final PrecoValidator precoValidator;
    private final PesoValidador pesoValidador;

    public ProdutoValidator() {
        this.nomeValidator = new NomeValidator();
        this.precoValidator = new PrecoValidator();
        this.pesoValidador = new PesoValidador();
    }

    public void validarCampos(String nome, Double peso, Double preco) {
        nomeValidator.validar(nome);
        precoValidator.validar(preco);
        pesoValidador.validar(peso);
    }
}
