package org.furb.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do PesoValidador")
class PesoValidadorTest {

    private final PesoValidador validator = new PesoValidador();

    @Nested
    @DisplayName("Validação de valores válidos")
    class ValoresValidos {

        @Test
        @DisplayName("Deve aceitar peso positivo")
        void deveAceitarPesoPositivo() {

            assertDoesNotThrow(() ->
                    validator.validar(1.0));
        }

        @Test
        @DisplayName("Deve aceitar peso decimal")
        void deveAceitarPesoDecimal() {

            assertDoesNotThrow(() ->
                    validator.validar(0.5));
        }

        @Test
        @DisplayName("Deve aceitar peso grande")
        void deveAceitarPesoGrande() {

            assertDoesNotThrow(() ->
                    validator.validar(9999.0));
        }
    }

    @Nested
    @DisplayName("Validação de valores inválidos")
    class ValoresInvalidos {

        @Test
        @DisplayName("Não deve aceitar peso negativo")
        void naoDeveAceitarPesoNegativo() {

            assertThrows(IllegalArgumentException.class,
                    () -> validator.validar(-1.0));
        }

        @Test
        @DisplayName("Não deve aceitar peso zero")
        void naoDeveAceitarPesoZero() {

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
        @DisplayName("Teste de múltiplas validações consecutivas")
        void validacoesRepetidas() {

            for (int i = 0; i < 1000; i++) {
                assertDoesNotThrow(() ->
                        validator.validar(1.5));
            }
        }
    }
}