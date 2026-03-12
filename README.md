# 📚 Sistema de Cálculo de Frete - Livraria

![Java](https://img.shields.io/badge/Java-19-orange)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![JUnit](https://img.shields.io/badge/JUnit-5-green)
![Status](https://img.shields.io/badge/status-concluído-success)

Sistema desenvolvido para uma **livraria que deseja iniciar suas vendas pela internet**, permitindo calcular automaticamente o **valor do frete de pedidos** com base no **peso total dos produtos** e na **modalidade de entrega escolhida**.

O projeto foi desenvolvido aplicando **boas práticas de engenharia de software**, arquitetura limpa e testes automatizados.

---

# 🎯 Objetivo do Projeto

Criar um sistema que permita ao dono da livraria calcular o valor do frete de um pedido contendo diversos produtos, considerando diferentes modalidades de entrega.

Além disso, o projeto busca demonstrar:

- aplicação de **Clean Code**
- princípios **SOLID**
- uso de **Design Patterns**
- criação de **testes unitários**
- organização de **arquitetura de software**

---

# 🏗 Arquitetura do Sistema

O sistema foi estruturado em camadas para garantir **baixo acoplamento e alta coesão**.

```
src
├── main
│ └── java
│ └── org.example
│ ├── model
│ │ ├── Produto
│ │ └── Pedido
│ │
│ ├── frete
│ │ ├── TipoFrete
│ │ ├── PACFrete
│ │ ├── SedexFrete
│ │ └── RetiradaLojaFrete
│ │
│ ├── service
│ │ └── CalculadoraFrete
│ │
│ └── validator
│ ├── Validador<T>
│ ├── ProdutoValidator
│ ├── PesoValidator
│ └── PrecoValidator
│
└── test
└── java
└── org.example
└── testes unitários
```

---

# 🧠 Padrões de Projeto Utilizados

## Strategy Pattern

O cálculo do frete utiliza o **Strategy Pattern**, permitindo que cada tipo de frete possua sua própria regra de cálculo.

Isso permite **adicionar novos tipos de frete sem modificar o código existente**, seguindo o princípio **Open/Closed (SOLID)**.

Exemplo da interface:

```java
public interface TipoFrete {
    double calcular(double pesoTotal);
}
```

---

# 📦 Regras de Cálculo de Frete

## 🚚 PAC

Peso do Pedido Valor
Até 1kg R$ 10,00
1kg a 2kg R$ 15,00
Acima de 2kg Não permitido

## ⚡ SEDEX

Peso do Pedido Valor
Até 500g R$ 12,50
500g a 1kg R$ 20,00
Acima de 1kg R$ 46,50 + R$ 1,50 para cada 100g adicional

## 🏪 Retirada na Loja

Tipo Valor
Retirada no local Grátis

# 🔎 Validação de Dados

## O projeto utiliza uma interface genérica de validação para garantir reutilização e consistência nas regras de validação.

```java
public interface Validador<T> {
    void validar(T valor);
}
```

## Implementações:

```java
ProdutoValidator
PesoValidator
PrecoValidator
```

Essa abordagem permite criar novas validações sem alterar o código existente.

---

# 🧪 Testes Automatizados

O sistema possui testes unitários utilizando JUnit 5.

Os testes seguem boas práticas de organização:

@Nested para agrupar cenários

@DisplayName para documentação dos testes

cobertura de múltiplos cenários

## Tipos de testes realizados

Casos válidos

Casos inválidos

Boundary values

Testes de robustez

Testes de segurança de entrada

### Exemplo de teste:

```java
@Nested
@DisplayName("Validação de nome do produto")
class ProdutoValidatorTest {

    @Test
    @DisplayName("Deve lançar exceção quando nome for nulo")
    void deveFalharQuandoNomeForNulo() {
        assertThrows(IllegalArgumentException.class,
            () -> validator.validar(null));
    }

}
```

---

# ⚙️ Tecnologias Utilizadas
## Tecnologia	Descrição

Java 19	          Linguagem principal
Maven	          Gerenciamento de dependências
JUnit 5	          Framework de testes

---

# ▶️ Como Executar o Projeto
Pré-requisitos

Java 19 ou superior

Maven

### Compilar o projeto
```
mvn clean install
```

### Executar os testes
```
mvn test
```

---

# 📈 Melhorias Futuras

## Possíveis evoluções do sistema:

integração com API de frete dos Correios

criação de API REST

persistência de pedidos em banco de dados

testes de integração

interface web para pedidos

---

# 👨‍💻 Autores

Luiz C. Martendal
Fabian Formento
Lucas Visconti

Estudantes de Ciência da Computação — FURB
