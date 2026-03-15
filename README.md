# 📈 Sistema Simplificado de Bolsa de Valores

Projeto desenvolvido para simular o funcionamento básico de uma **Bolsa de Valores**, permitindo o registro de **ordens de compra e venda de ações**, execução de **matching de ordens** e **notificação de investidores** quando ocorre negociação.

O projeto foi desenvolvido em **Java**, utilizando boas práticas de **orientação a objetos**, separação em **camadas de domínio e serviço**, além de possuir **testes automatizados com JUnit 5 e Mockito**.

---

# 🧠 Conceito do Sistema

O sistema simula um **mercado de ações simplificado**.

Investidores podem registrar ordens de:

* 📉 **Venda**
* 📈 **Compra**

Quando uma **ordem de compra e uma ordem de venda possuem o mesmo valor**, ocorre um **match** (negociação), atualizando o valor da ação e notificando os investidores que estão observando essa ação.

---

# 🏗️ Arquitetura do Projeto

O sistema está dividido em dois pacotes principais:

```
br.furb
 ├── models
 │    ├── Acao
 │    ├── Ordem
 │    ├── UsuarioInvestidor
 │    └── enums
 │         └── TipoOrdem
 │
 └── services
      ├── BolsaDeValoresService
      ├── MatchingService
      └── NotificacaoService
```

## 📦 Models (Domínio)

Representam as entidades principais do sistema.

### `Acao`

Representa uma ação negociada na bolsa.

Responsabilidades:

* armazenar ordens de compra e venda
* manter valor atual da ação
* gerenciar investidores observadores
* controlar prioridade das ordens usando `PriorityQueue`

Regras:

* **Compra → maior valor tem prioridade**
* **Venda → menor valor tem prioridade**

---

### `Ordem`

Representa uma ordem de negociação.

Contém:

* investidor responsável
* tipo da ordem (COMPRA ou VENDA)
* valor da ordem

---

### `UsuarioInvestidor`

Representa um usuário que participa do mercado.

Responsabilidades:

* receber notificações quando o valor da ação muda

---

### `TipoOrdem`

Enumeração que define:

```
COMPRA
VENDA
```

---

# ⚙️ Camada de Serviços

## `BolsaDeValoresService`

Responsável por:

* registrar ações
* registrar ordens
* encaminhar ordens para processamento de matching

---

## `MatchingService`

Implementa a **lógica de negociação de mercado**.

Algoritmo:

1. verifica melhor compra
2. verifica melhor venda
3. se valores forem iguais → ocorre negociação
4. remove ordens executadas
5. atualiza valor da ação
6. dispara notificações

---

## `NotificacaoService`

Responsável por notificar todos os investidores que estão observando a ação.

Exemplo de notificação:

```
Carlos foi notificado: PETR4 agora vale 50
```

---

# 🧪 Testes Automatizados

O projeto possui **testes automatizados utilizando:**

* **JUnit 5**
* **Mockito**
* **Testes Black-box**
* **Estrutura com @Nested e @DisplayName**

Estratégia de testes:

* cenários positivos
* cenários negativos
* edge cases
* validação de regras de prioridade
* validação de múltiplos matches

---

# 📊 Cobertura de Testes

Cobertura média obtida:

```
97% – 100%
```

Cobertura por classe:

| Classe                | Cobertura |
| --------------------- | --------- |
| Acao                  | ~98%      |
| Ordem                 | 100%      |
| UsuarioInvestidor     | ~95%      |
| BolsaDeValoresService | ~95%      |
| MatchingService       | ~100%     |
| NotificacaoService    | ~100%     |

---

# ▶️ Como Executar o Projeto

## 1️⃣ Clonar repositório

```
git clone <url-do-repositorio>
```

---

## 2️⃣ Compilar projeto

Se estiver usando **Maven**:

```
mvn clean install
```

---

## 3️⃣ Executar testes

```
mvn test
```

---

# 🧩 Tecnologias Utilizadas

* Java
* Maven
* JUnit 5
* Mockito

---

# 🎯 Objetivo Acadêmico

Este projeto foi desenvolvido para praticar conceitos de:

* orientação a objetos
* estruturação de domínio
* design de serviços
* testes automatizados
* qualidade de software
* cobertura de testes

---

# 👨‍💻 Autores

Projeto desenvolvido para a disciplina de **Analise de Algoritmos**.

**Alunos:**
Luiz C. Martendal
Fabian Formento
Lucas Visconti

**Universidade:**
FURB – Universidade Regional de Blumenau

---

# 📄 Licença

Este projeto é apenas para fins **educacionais e acadêmicos**.
