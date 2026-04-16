# Projeto: Análise de Desempenho ArrayList vs LinkedList

## Descrição do Projeto

Este projeto é uma implementação prática dos exercícios da Lista 01 da disciplina "Análise de Algoritmos" do Professor Gabriel Castellani de Oliveira da Universidade Regional de Blumenau (FURB).

O objetivo é comparar experimentalmente o desempenho de duas estruturas de dados lineares:
- **ArrayList** (baseado em vetor dinâmico)
- **LinkedList** (baseado em lista encadeada)

---

## Estrutura do Projeto

```
exercicios/
├── pom.xml                              # Configuração Maven
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   ├── Main.java        # Classe principal
│                   ├── questao01/
│                   │   ├── Q01CapacidadeInicial.java
│                   │   └── Q01InsercaoFinal.java
│                   ├── questao02/
│                   │   └── Q02InsercaoAleatoria.java
│                   ├── questao03/
│                   │   └── Q03Remocoes.java
│                   ├── questao04/
│                   │   └── Q04RemocaoAleatoria.java
│                   └── questao05/
│                       └── Q05AcessoAleatorio.java
│
├── RESPOSTAS_QUESTOES.md               # Respostas detalhadas
├── ANALISE_RESULTADOS.md               # Análise profunda dos resultados
├── RESUMO_EXECUTIVO.md                 # Resumo executivo
└── README.md                           # Este arquivo
```

---

## Requisitos

- **Java:** 17 ou superior
- **Maven:** 3.6 ou superior
- **Sistema Operacional:** Windows, Linux ou macOS

---

## Como Executar

### Compilação

```bash
cd exercicios
mvn clean compile
```

### Execução

```bash
java -cp target/classes org.example.Main
```

Ou via Maven:

```bash
mvn exec:java@exec
```

---

## Descrição das Questões

### Questão 1: Inserção ao Final
**Arquivo:** `Q01InsercaoFinal.java` e `Q01CapacidadeInicial.java`

Compara a velocidade de inserção de novos elementos ao final de ambas estruturas com:
- 20 testes com 100.000 elementos
- Avaliação do impacto de diferentes capacidades iniciais (10, 1.000, 1.000.000)

**Resultado:** LinkedList 1.22x mais rápido (mas diferença mínima)

### Questão 2: Inserção em Posição Aleatória
**Arquivo:** `Q02InsercaoAleatoria.java`

Cada inserção ocorre em uma posição aleatória válida da lista.
- 20 testes com 50.000 elementos

**Resultado:** ArrayList 37.76x mais rápido (INESPERADO! Contraria teoria)

### Questão 3: Remoção de Elementos
**Arquivo:** `Q03Remocoes.java`

Avalia tempo para remover todos os elementos:
- Teste 1: Sempre remover o primeiro elemento (20 testes, 100.000 elementos)
- Teste 2: Sempre remover o último elemento (20 testes, 100.000 elementos)

**Resultados:**
- Remoção do final: ArrayList 1.73x mais rápido
- Remoção do início: LinkedList 958.96x mais rápido (ESPERADO!)

### Questão 4: Remoção em Posição Aleatória
**Arquivo:** `Q04RemocaoAleatoria.java`

Remover elementos de índices aleatórios até que a lista fique vazia.
- 20 testes com 50.000 elementos

**Resultado:** ArrayList 16.09x mais rápido (INESPERADO!)

### Questão 5: Acesso Aleatório
**Arquivo:** `Q05AcessoAleatorio.java`

Realiza 10.000 acessos a índices aleatórios válidos.
- 20 testes com 100.000 elementos

**Resultado:** ArrayList 2167.60x mais rápido (CONFIRMADO pela teoria!)

### Questão 6: Síntese e Análise
**Documentos:** Consulte `RESPOSTAS_QUESTOES.md`

Análise completa dos resultados, confirmações e divergências em relação à teoria.

---

## Resultados Principais

| Operação | ArrayList | LinkedList | Vencedor | Razão |
|----------|-----------|------------|----------|-------|
| Inserção Final | 1.88 ms | 1.54 ms | LL | 1.22x |
| Inserção Aleatória | 72.82 ms | 2753.36 ms | AL | 37.76x ⚠️ |
| Remoção Final | 0.60 ms | 1.04 ms | AL | 1.73x |
| Remoção Inicial | 508.25 ms | 0.53 ms | LL | 958.96x ✓ |
| Remoção Aleatória | 68.98 ms | 1110.02 ms | AL | 16.09x ⚠️ |
| Acesso Aleatório | 0.20 ms | 433.52 ms | AL | 2167.60x ✓ |

**Legenda:** ✓ = Resultado esperado pela teoria | ⚠️ = Resultado contrário à teoria

---

## Conclusões Principais

### ArrayList é mais vantajoso para:
✅ Acesso aleatório frequente  
✅ Inserção/remoção no final  
✅ Performance geral  
✅ Cache locality  

### LinkedList é mais vantajoso para:
✅ Remoção do início (O(1) garantido)  
✅ Implementações de fila/pilha  
✅ Acesso aleatório raro  

### Observação Importante:

Os resultados experimentais **não confirmaram completamente** a teoria de complexidade assintótica Big-O em alguns cenários. Fatores práticos como:
- **Cache de CPU** 
- **Otimizações JIT da JVM**
- **Overhead de memória**
- **Eficiência de alocação**

...frequentemente **dominam a performance real** sobre a complexidade teórica.

---

## Documentação Entregue

### 1. RESPOSTAS_QUESTOES.md
Respostas detalhadas para cada uma das 6 questões com:
- Tempos de execução
- Análises
- Explicações técnicas
- Tabelas comparativas

### 2. ANALISE_RESULTADOS.md
Análise profunda com:
- Discussão de cada resultado
- Comparação com teoria
- Explicação de fatores práticos
- Tabelas resumidas

### 3. RESUMO_EXECUTIVO.md
Visão geral executiva com:
- Quadro geral de comparação
- Análise resumida por questão
- Recomendações de uso
- Conclusões finais

---

## Referências Teóricas

### Complexidade Esperada:

**ArrayList (Vetor Dinâmico):**
- Acesso: O(1)
- Inserção no final: O(1) amortizado
- Inserção aleatória: O(n)
- Remoção aleatória: O(n)

**LinkedList (Lista Encadeada):**
- Acesso: O(n)
- Inserção no final: O(1) ou O(n) (depende de implementação)
- Inserção aleatória: O(n)
- Remoção aleatória: O(n)

---

## Ambiente de Teste

- **Java Version:** 17
- **JVM:** Com otimizações JIT ativadas
- **Hardware:** Computador moderno com cache CPU múltiplos níveis
- **Sistema Operacional:** Windows 10/11
- **Data de Execução:** 13 de Abril de 2026

---

## Como Modificar e Estender

### Para alterar número de testes:
Edite a constante `TESTES` em cada classe de questão.

```java
private static final int TESTES = 20;  // Aumentar para mais testes
```

### Para alterar número de elementos:
Edite a constante `ELEMENTOS` em cada classe.

```java
private static final int ELEMENTOS = 100000;  // Aumentar para mais dados
```

### Para adicionar nova questão:
1. Crie nova classe em `src/main/java/org/example/questaoXX/`
2. Implemente métodos de teste
3. Chame da classe `Main.java`

---

## Troubleshooting

### Erro: "package org.example does not exist"
```bash
mvn clean compile
```

### Erro: "Java version mismatch"
Verifique se Java 17+ está instalado:
```bash
java -version
```

### Erro: "Maven not found"
Instale Maven ou use:
```bash
./mvnw clean compile  # Windows: mvnw.cmd clean compile
```

---

## Autor

Estudante de Análise de Algoritmos - FURB  
Período: 5º Semestre - 2026/1  

---

## Licença

Este projeto é para fins acadêmicos da FURB.

---

## Contato

Professor: Gabriel Castellani de Oliveira  
Universidade: Universidade Regional de Blumenau (FURB)  
Departamento: Sistemas e Computação

---

**Última atualização:** 13 de Abril de 2026

