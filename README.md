# 📈 Simulador de Bolsa de Valores - Problema 2

Projeto desenvolvido para a disciplina de **Análise de Algoritmos** da FURB.

## 👥 Integrantes

* Fabian Formento
* Lucas Visconti
* Luiz Carlos Martendal

---

## 📌 Descrição

Este projeto simula o funcionamento básico de uma bolsa de valores, onde investidores podem:

* Registrar ordens de **compra** e **venda** de ações
* Se inscrever em ações para receber atualizações de preço
* Ter suas ordens processadas automaticamente pelo sistema

Quando ocorre um *match* entre uma ordem de compra e uma ordem de venda, a negociação é realizada, o valor da ação é atualizado e os investidores inscritos são notificados.

---

## ⚙️ Funcionalidades

✔️ Cadastro de ações
✔️ Registro de ordens de compra e venda
✔️ Processamento automático de ordens (matching)
✔️ Atualização do valor da ação após negociação
✔️ Notificação de investidores (Observer)
✔️ Testes unitários

---

## 🧠 Regras de Negociação

O sistema realiza o *match* quando:

* O valor da melhor ordem de compra é **igual** que o valor da melhor ordem de venda

Quando isso acontece:

1. A negociação é realizada
2. O valor da ação é atualizado
3. As ordens são removidas
4. Investidores inscritos são notificados

---

## 🏗️ Estrutura do Projeto

```
br.furb
│
├── models
│   ├── Acao
│   ├── Ordem
│   ├── UsuarioInvestidor
│   └── enums
│       └── TipoOrdem
│
├── services
│   ├── BolsaDeValoresService
│   ├── MatchingService
│   └── NotificacaoService
```

---

## 🧩 Padrões Utilizados

* **Observer Pattern** → notificação de investidores
* **Separation of Concerns** → lógica dividida em serviços
* **Priority Queue** → organização eficiente das ordens

---

## ⚡ Estrutura de Dados

O sistema utiliza:

* `PriorityQueue` para ordens de compra (maior valor primeiro)
* `PriorityQueue` para ordens de venda (menor valor primeiro)

Isso garante que as melhores ordens sejam processadas primeiro.

---

## 📊 Diagrama de Classes

O projeto possui um diagrama de classes em UML representando toda a estrutura da aplicação, conforme solicitado no enunciado.

---

## 📚 Referência

Trabalho proposto na disciplina de Análise de Algoritmos — FURB.
