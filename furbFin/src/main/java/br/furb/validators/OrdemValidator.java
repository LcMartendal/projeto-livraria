package br.furb.validators;

import br.furb.models.UsuarioInvestidor;
import br.furb.models.enums.TipoOrdem;

import java.math.BigDecimal;

public class OrdemValidator {

    public void validar(UsuarioInvestidor investidor, TipoOrdem tipoOrdem, BigDecimal valor) {
        if (investidor == null) throw new IllegalArgumentException("Investidor é obrigatório");

        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Valor inválido");
    }
}
