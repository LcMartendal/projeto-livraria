package org.furb.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.furb.validator.utils.PrecoValidator;

@DisplayName("Testes do PrecoValidator")
class PrecoValidatorTest {

    private final PrecoValidator validator = new PrecoValidator();

    @Nested
    @DisplayName("Validação de preços válidos")
    class ValoresValidos {

        @Test
        @DisplayName("Deve aceitar preço positivo")
        void deveAceitarPrecoPositivo() {

            assertDoesNotThrow(() ->
                    validator.validar(100.0));
        }

        @Test
        @DisplayName("Deve aceitar preço decimal")
        void deveAceitarPrecoDecimal() {

            assertDoesNotThrow(() ->
                    validator.validar(19.99));
        }

        @Test
        @DisplayName("Deve aceitar preço alto")
        void deveAceitarPrecoAlto() {

            assertDoesNotThrow(() ->
                    validator.validar(999999.0));
        }
    }

    @Nested
    @DisplayName("Validação de valores inválidos")
    class ValoresInvalidos {

        @Test
        @DisplayName("Não deve aceitar preço negativo")
        void naoDeveAceitarPrecoNegativo() {

            assertThrows(IllegalArgumentException.class,
                    () -> validator.validar(-10.0));
        }

        @Test
        @DisplayName("Não deve aceitar preço zero")
        void naoDeveAceitarPrecoZero() {

            assertThrows(IllegalArgumentException.class,
                    () -> validator.validar(0.0));
        }
    }

    @Nested
    @DisplayName("Testes de robustez")
    class Robustez {

        @Test
        @DisplayName("Não deve aceitar valor nulo")
        void naoDeveAceitarNull() {

            assertThrows(Exception.class,
                    () -> validator.validar(null));
        }

        @Test
        @DisplayName("Teste de validação repetida")
        void validacaoRepetida() {

            for (int i = 0; i < 1000; i++) {

                assertDoesNotThrow(() ->
                        validator.validar(50.0));
            }
        }
    }
}