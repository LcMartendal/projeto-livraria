package br;

import br.furb.models.Acao;
import br.furb.models.Ordem;
import br.furb.models.UsuarioInvestidor;
import br.furb.models.enums.TipoOrdem;
import br.furb.services.BolsaDeValoresService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        BolsaDeValoresService bolsa =
                new BolsaDeValoresService();

        Acao bb = new Acao("BBAS3", new BigDecimal("23.50"));

        bolsa.adicionarAcao(bb);

        UsuarioInvestidor mariana = new UsuarioInvestidor("Mariana");
        UsuarioInvestidor joaquim = new UsuarioInvestidor("Joaquim");

        bb.registrarInvestidor(mariana);
        bb.registrarInvestidor(joaquim);

        bolsa.registrarOrdem(
                "BBAS3",
                new Ordem("Mariana", TipoOrdem.VENDA, new BigDecimal("24"))
        );

        bolsa.registrarOrdem(
                "BBAS3",
                new Ordem("Joaquim", TipoOrdem.COMPRA, new BigDecimal("24"))
        );
    }
}
