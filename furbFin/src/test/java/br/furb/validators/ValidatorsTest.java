package br.furb.validators;

import br.furb.models.UsuarioInvestidor;
import br.furb.models.enums.TipoOrdem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorsTest {

    // -------------------- AcaoValidator --------------------
    @Test
    void acaoValidatorValido() {
        AcaoValidator validator = new AcaoValidator();
        assertDoesNotThrow(() -> validator.validar("PETR4", BigDecimal.valueOf(10)));
    }

    @Test
    void acaoValidatorNomeNuloOuVazio() {
        AcaoValidator validator = new AcaoValidator();

        Exception e1 = assertThrows(IllegalArgumentException.class,
                () -> validator.validar(null, BigDecimal.valueOf(10)));
        assertEquals("Nome não pode ser vazio", e1.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class,
                () -> validator.validar("   ", BigDecimal.valueOf(10)));
        assertEquals("Nome não pode ser vazio", e2.getMessage());
    }

    @Test
    void acaoValidatorValorNuloOuNegativo() {
        AcaoValidator validator = new AcaoValidator();

        Exception e1 = assertThrows(IllegalArgumentException.class,
                () -> validator.validar("PETR4", null));
        assertEquals("Valor não pode ser negativo", e1.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class,
                () -> validator.validar("PETR4", BigDecimal.valueOf(-1)));
        assertEquals("Valor não pode ser negativo", e2.getMessage());
    }

    // -------------------- UsuarioInvestidorValidator --------------------
    @Test
    void usuarioInvestidorValidatorValido() {
        UsuarioInvestidorValidator validator = new UsuarioInvestidorValidator();
        assertDoesNotThrow(() -> validator.validar("Carlos Silva"));
    }

    @Test
    void usuarioInvestidorValidatorNomeNuloOuVazio() {
        UsuarioInvestidorValidator validator = new UsuarioInvestidorValidator();

        Exception e1 = assertThrows(IllegalArgumentException.class,
                () -> validator.validar(null));
        assertEquals("Nome é obrigatório", e1.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class,
                () -> validator.validar("   "));
        assertEquals("Nome é obrigatório", e2.getMessage());
    }

    @Test
    void usuarioInvestidorValidatorNomeInvalido() {
        UsuarioInvestidorValidator validator = new UsuarioInvestidorValidator();

        Exception e1 = assertThrows(IllegalArgumentException.class,
                () -> validator.validar("Carlos123"));
        assertEquals("Nome inválido", e1.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class,
                () -> validator.validar("João!"));
        assertEquals("Nome inválido", e2.getMessage());
    }

    // -------------------- OrdemValidator --------------------
    @Test
    void ordemValidatorValida() {
        OrdemValidator validator = new OrdemValidator();
        UsuarioInvestidor investidor = new UsuarioInvestidor("A");
        assertDoesNotThrow(() -> validator.validar(investidor, TipoOrdem.COMPRA, BigDecimal.valueOf(100)));
    }

    @Test
    void ordemValidatorInvestidorNulo() {
        OrdemValidator validator = new OrdemValidator();

        Exception e = assertThrows(IllegalArgumentException.class,
                () -> validator.validar(null, TipoOrdem.COMPRA, BigDecimal.valueOf(100)));
        assertEquals("Investidor é obrigatório", e.getMessage());
    }

    @Test
    void ordemValidatorValorNuloOuNegativo() {
        OrdemValidator validator = new OrdemValidator();
        UsuarioInvestidor investidor = new UsuarioInvestidor("A");

        Exception e1 = assertThrows(IllegalArgumentException.class,
                () -> validator.validar(investidor, TipoOrdem.COMPRA, null));
        assertEquals("Valor inválido", e1.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class,
                () -> validator.validar(investidor, TipoOrdem.COMPRA, BigDecimal.valueOf(-10)));
        assertEquals("Valor inválido", e2.getMessage());
    }
}