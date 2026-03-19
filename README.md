# 📈 Simulador de Bolsa de Valores - Problema 2

Projeto desenvolvido para a disciplina de **Análise de Algoritmos** da FURB.

---

## 👥 Integrantes

* Fabian Formento
* Lucas Visconti
* Luiz C. Martendal

---

## 📌 Descrição

Este projeto implementa uma simulação de uma bolsa de valores, permitindo que investidores realizem operações de compra e venda de ações, além de receber notificações em tempo real sobre mudanças de preço.

O sistema processa automaticamente ordens de compra e venda, realizando negociações quando há compatibilidade entre elas (*matching*).

---

## ⚙️ Funcionalidades

✔️ Cadastro de ações
✔️ Registro de ordens de compra e venda
✔️ Processamento automático de negociações
✔️ Atualização do valor das ações
✔️ Notificação de investidores inscritos
✔️ Validação de dados de entrada
✔️ Testes unitários

---

## 🧠 Regras de Negociação

Uma negociação ocorre quando:

* O valor da melhor ordem de compra é **maior ou igual** ao valor da melhor ordem de venda

Quando isso acontece:

1. A negociação é executada
2. O valor da ação é atualizado com base no preço de venda
3. As ordens são removidas
4. Investidores inscritos são notificados

---

## 🏗️ Arquitetura

O sistema foi dividido em camadas para melhor organização:

```text
models      → entidades do domínio
services    → regras de negócio
validators  → validação de dados
```

---

## 🧩 Padrões e Boas Práticas

* **Observer Pattern** → notificação de investidores
* **Separation of Concerns** → separação clara de responsabilidades
* **Encapsulamento** → controle de acesso aos dados
* **Imutabilidade parcial** → uso de atributos `final`
* **Validação dedicada** → classes específicas para validação

---

## ⚡ Estruturas Utilizadas

* `List` para armazenamento de ordens
* `Stream API` para busca da melhor compra/venda
* `BigDecimal` para precisão em valores monetários

---

## 🔄 Fluxo do Sistema

1. Investidor cria uma ordem
2. Ordem é associada a uma ação
3. Sistema tenta realizar *matching*
4. Se houver negociação:

   * valor da ação é atualizado
   * investidores são notificados

---

## 🧪 Testes Unitários

Foram implementados testes para validar:

✔️ Execução de match
✔️ Não ocorrência de match inválido
✔️ Atualização correta do valor
✔️ Validação de entradas
✔️ Notificação de investidores

---

## ▶️ Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/LcMartendal/trabalhos-analise-de-algoritmos.git
```

2. Acesse a branch:

```bash
git checkout problema-2-pt-1
```

3. Execute os testes na sua IDE ou via Maven/Gradle.

---

## 📊 Diagrama UML

O projeto inclui um diagrama de classes UML representando a estrutura completa da aplicação, incluindo entidades, serviços e validadores.

---

## 🎯 Objetivo Acadêmico

Aplicar conceitos de:

* Programação Orientada a Objetos
* Estruturas de dados
* Modelagem UML
* Arquitetura de software
* Testes automatizados

---

## 📎 Observações

* Sistema simplificado (não considera volume de ações)
* Foco na lógica de negociação e arquitetura
* Implementação voltada para fins acadêmicos

---

## 🚀 Status

✔️ Implementação concluída
✔️ Arquitetura organizada
✔️ Validações implementadas
✔️ Testes unitários implementados
✔️ Diagrama UML criado

---
