package org.furb.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do ProdutoValidator")
class ProdutoValidatorTest {

    private final ProdutoValidator validator = new ProdutoValidator();

    @Nested
    @DisplayName("Validação de campos válidos")
    class ValoresValidos {

        @Test
        @DisplayName("Deve aceitar nome, peso e preço válidos")
        void deveAceitarCamposValidos() {
            assertDoesNotThrow(() -> validator.validarCampos("Livro", 1.0, 10.0));
        }
    }

    @Nested
    @DisplayName("Validação de valores inválidos")
    class ValoresInvalidos {

        @Test
        @DisplayName("Não deve aceitar nome nulo")
        void naoDeveAceitarNomeNull() {
            assertThrows(IllegalArgumentException.class,
                    () -> validator.validarCampos(null, 1.0, 10.0));
        }

        @Test
        @DisplayName("Não deve aceitar nome vazio")
        void naoDeveAceitarNomeVazio() {
            assertThrows(IllegalArgumentException.class,
                    () -> validator.validarCampos("", 1.0, 10.0));
        }

        @Test
        @DisplayName("Não deve aceitar nome com caracteres inválidos")
        void naoDeveAceitarNomeComCaracteresInvalidos() {
            assertThrows(IllegalArgumentException.class,
                    () -> validator.validarCampos("@Livro#", 1.0, 10.0));
        }

        @Test
        @DisplayName("Não deve aceitar peso nulo")
        void naoDeveAceitarPesoNull() {
            assertThrows(Exception.class,
                    () -> validator.validarCampos("Livro", null, 10.0));
        }

        @Test
        @DisplayName("Não deve aceitar peso negativo")
        void naoDeveAceitarPesoNegativo() {
            assertThrows(IllegalArgumentException.class,
                    () -> validator.validarCampos("Livro", -1.0, 10.0));
        }

        @Test
        @DisplayName("Não deve aceitar preço nulo")
        void naoDeveAceitarPrecoNull() {
            assertThrows(Exception.class,
                    () -> validator.validarCampos("Livro", 1.0, null));
        }

        @Test
        @DisplayName("Não deve aceitar preço negativo")
        void naoDeveAceitarPrecoNegativo() {
            assertThrows(IllegalArgumentException.class,
                    () -> validator.validarCampos("Livro", 1.0, -5.0));
        }
    }

    @Nested
    @DisplayName("Testes de robustez")
    class Robustez {

        @Test
        @DisplayName("Validação repetida não deve falhar para valores válidos")
        void validacaoRepetida() {
            for (int i = 0; i < 1000; i++) {
                assertDoesNotThrow(() -> validator.validarCampos("Livro", 1.5, 20.0));
            }
        }
    }
}
