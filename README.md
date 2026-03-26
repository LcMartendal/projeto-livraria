# 🖱️ OneClick - Automação de Dispositivos IoT (Problema 3)

Projeto desenvolvido para a disciplina de **Análise de Algoritmos** da FURB. O sistema foca na gestão eficiente de comandos e estados de dispositivos inteligentes via rede, utilizando uma biblioteca de integração de hardware.

## 👥 Integrantes

* Fabian Formento
* Lucas Visconti
* Luiz Carlos Martendal

---

## 📌 Descrição

O **OneClick** é um ecossistema de controle para dispositivos IoT (Internet of Things). O projeto visa gerenciar a comunicação entre uma central de controle e diversos sensores/atuadores, permitindo:

* O registro e monitoramento de dispositivos em tempo real.
* O envio de comandos prioritários (ligar, desligar, configurar).
* A integração com a biblioteca robusta de dispositivos `LibDispositivosIot`.

Quando um dispositivo altera seu estado ou um sensor detecta uma variação, o sistema processa a informação e propaga a atualização para os módulos de monitoramento conectados.

---

## ⚙️ Funcionalidades

✔️ Cadastro e descoberta de novos dispositivos IoT.
✔️ Envio de comandos "OneClick" para execução imediata.
✔️ Processamento de filas de mensagens de sensores.
✔️ Integração nativa com a biblioteca externa `LibDispositivosIot-1.0.jar`.
✔️ Sistema de logs de eventos e telemetria para análise de performance.
✔️ Testes unitários de latência e processamento de dados.

---

## 🧠 Regras de Operação

O sistema gerencia os dispositivos seguindo este fluxo lógico:

1. **Priorização**: Comandos críticos (ex: alarmes) possuem maior prioridade na fila de execução do que comandos de rotina.
2. **Sincronização de Estado**: O estado do objeto no sistema deve ser um reflexo fiel do hardware fornecido pela `LibDispositivosIot`.
3. **Gerenciamento de Timeouts**: Comandos que excedem o tempo limite de resposta da rede são descartados para evitar comportamentos inesperados.

---

## 🧩 Tecnologias e Padrões

Java 17: Versão de destino configurada no Maven.

Maven: Gerenciamento de dependências e automação de build.

Command Pattern: Utilizado para encapsular cada ação do usuário como um objeto "Click".

Observer Pattern: Utilizado para que a central reaja a mudanças enviadas pelos sensores IoT.

## 🛠️ Configuração de Dependências
O projeto utiliza uma dependência de sistema local. Certifique-se de que o arquivo JAR está no caminho correto para que o Maven possa compilar o projeto:

Caminho esperado:
src/main/resources/LibDispositivosIot-1.0.jar

Trecho do pom.xml:

```XML
<dependency>
    <groupId>br.furb.analise.algoritmos</groupId>
    <artifactId>LibDispositivosIot</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
---

## 📚 Referência
Trabalho proposto na disciplina de Análise de Algoritmos — FURB.
