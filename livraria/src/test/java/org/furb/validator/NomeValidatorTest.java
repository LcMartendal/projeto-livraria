package org.furb.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.furb.validator.utils.NomeValidator;

@DisplayName("Testes do ProdutoValidator")
class NomeValidatorTest {

    private final NomeValidator validator = new NomeValidator();

    @Nested
    @DisplayName("Validação de nomes válidos")
    class ValoresValidos {

        @Test
        @DisplayName("Deve aceitar nome simples")
        void deveAceitarNomeSimples() {
            assertDoesNotThrow(() -> validator.validar("Livro"));
        }

        @Test
        @DisplayName("Deve aceitar nome com espaços")
        void deveAceitarNomeComEspacos() {
            assertDoesNotThrow(() -> validator.validar("Livro de Java"));
        }

        @Test
        @DisplayName("Deve aceitar nome longo")
        void deveAceitarNomeLongo() {

            String nome = "Livro de Arquitetura de Software e Padrões de Projeto";

            assertDoesNotThrow(() -> validator.validar(nome));
        }
    }

    @Nested
    @DisplayName("Validação de valores inválidos")
    class ValoresInvalidos {

        @Test
        @DisplayName("Não deve aceitar nome nulo")
        void naoDeveAceitarNull() {

            assertThrows(IllegalArgumentException.class,
                    () -> validator.validar(null));
        }
    }

    @Nested
    @DisplayName("Boundary cases")
    class BoundaryCases {

        @Test
        @DisplayName("Não aceita string vazia (comportamento atual)")
        void naoAceitaStringVazia() {

            assertThrows(IllegalArgumentException.class,
                    () -> validator.validar(""));
        }

        @Test
        @DisplayName("Não aceita apenas espaços (comportamento atual)")
        void naoAceitaApenasEspacos() {

            assertThrows(IllegalArgumentException.class,
                    () -> validator.validar("   "));
        }
    }

    @Nested
    @DisplayName("Testes de robustez e segurança")
    class RobustezSeguranca {

        @Test
        @DisplayName("Não deve aceitar caracteres especiais")
        void naoDeveaceitarCaracteresEspeciais() {

            assertThrows(IllegalArgumentException.class, () -> validator.validar("@#$% Livro *&^%"));
        }

        @Test
        @DisplayName("Aceita nome extremamente longo")
        void nomeExtremamenteLongo() {

            String nome = "A".repeat(10000);

            assertDoesNotThrow(() -> validator.validar(nome));
        }

        @Test
        @DisplayName("Validação repetida não deve falhar")
        void validacaoRepetida() {

            for (int i = 0; i < 1000; i++) {
                assertDoesNotThrow(() -> validator.validar("Livro"));
            }
        }
    }
}
