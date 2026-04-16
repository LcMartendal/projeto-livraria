# Respostas Detalhadas - Lista de Exercícios 01
## Universidade Regional de Blumenau - FURB
### Disciplina: Análise de Algoritmos
### Professor: Gabriel Castellani de Oliveira

---

## Introdução

Este documento apresenta as respostas detalhadas para a Lista de Exercícios 01 da disciplina de Análise de Algoritmos. O trabalho consistiu no desenvolvimento de uma aplicação experimental para comparar o desempenho de duas estruturas de dados lineares: ArrayList (baseado em vetor dinâmico) e LinkedList (baseado em lista encadeada).

A aplicação foi implementada em Java, utilizando as estruturas nativas da linguagem: `java.util.ArrayList` e `java.util.LinkedList`. Os testes foram realizados com medições precisas de tempo de execução, utilizando `System.nanoTime()` para garantir precisão nas medições.

---

## Questão 1: Inserção ao Final

### Exercício 1.1 - Comparação Entre ArrayList e LinkedList

**Objetivo:** Comparar a velocidade de inserção de novos elementos ao final das duas estruturas.

**Metodologia:**
- Número de testes: 20 execuções
- Número de elementos: 100.000 por teste
- Operação: Inserção sequencial ao final da lista
- Medição: Tempo total de preenchimento da lista

**Resultados Experimentais:**
```
Tempo médio do ArrayList:   1.88034495 ms
Tempo médio do LinkedList:  1.5436650000000003 ms
Lista mais rápida: LinkedList
Quantidade de vitórias: LinkedList (10) vs ArrayList (10)
Razão de desempenho: LinkedList 1.22x mais rápido
```

**Análise:**
O LinkedList apresentou desempenho ligeiramente superior nesta operação, embora a diferença seja mínima (aproximadamente 0.34 ms em média). Os resultados foram equilibrados, com cada estrutura vencendo 10 das 20 execuções. Este resultado contrasta com a teoria, que prevê desempenho similar para ambas as estruturas em inserções ao final (O(1) amortizado para ArrayList e O(1) para LinkedList).

### Exercício 1.2 - Influência da Capacidade Inicial do ArrayList

**Objetivo:** Avaliar se a alteração da capacidade inicial influencia no desempenho do ArrayList.

**Metodologia:**
- Número de testes: 10 execuções por configuração
- Número de elementos: 100.000 por teste
- Capacidades testadas: 10, 1.000 e 1.000.000
- Operação: Inserção sequencial ao final da lista

**Resultados Experimentais:**
```
Capacidade 10:        2.3924801 ms
Capacidade 1.000:     2.4198798999999993 ms
Capacidade 1.000.000: 2.3294401000000002 ms
Configuração mais rápida: Capacidade 1.000.000
```

**Análise:**
A configuração com capacidade inicial de 1.000.000 foi a mais rápida, apresentando tempo médio de 2.33 ms. Este resultado confirma a teoria de que uma capacidade inicial adequada evita realocações desnecessárias durante o crescimento do ArrayList.

**Por que isso acontece?**
1. **Capacidade 10:** Requer múltiplas realocações (10 → 20 → 40 → ... → 131.072), cada uma envolvendo cópia de todos os elementos existentes.
2. **Capacidade 1.000:** Ainda necessita de várias realocações, embora menos frequentes.
3. **Capacidade 1.000.000:** Pré-aloca espaço suficiente, eliminando praticamente todas as realocações durante a inserção dos 100.000 elementos.

---

## Questão 2: Inserção em Posição Aleatória

### Exercício 2.1 - Comparação Entre ArrayList e LinkedList

**Objetivo:** Comparar a velocidade de inserção quando cada elemento é inserido em uma posição aleatória válida da lista.

**Metodologia:**
- Número de testes: 20 execuções
- Número de elementos: 50.000 por teste
- Operação: Inserção em posição aleatória (índice entre 0 e tamanho atual da lista)
- Medição: Tempo total de preenchimento da lista

**Resultados Experimentais:**
```
Tempo médio do LinkedList:  2753.36191505 ms
Tempo médio do ArrayList:   72.82327485 ms
Lista mais rápida: ArrayList
Quantidade de vitórias: ArrayList (20/20)
Razão de desempenho: ArrayList 37.76x mais rápido
```

**Análise:**
O ArrayList apresentou desempenho drasticamente superior, sendo aproximadamente 38 vezes mais rápido que o LinkedList. Este resultado contraria a teoria de complexidade assintótica, que prevê vantagem para o LinkedList em operações de inserção aleatória (O(n) para ambos, mas com constantes diferentes).

---

## Questão 3: Remoção de Elementos

### Exercício 3.1 - Remoção do Primeiro Elemento

**Objetivo:** Avaliar o tempo necessário para remover todos os elementos, sempre removendo o primeiro elemento da lista.

**Metodologia:**
- Número de testes: 20 execuções
- Número de elementos inicial: 100.000 por teste
- Operação: Remoção sequencial do primeiro elemento até esvaziar a lista
- Medição: Tempo total de esvaziamento da lista

**Resultados Experimentais:**
```
Tempo médio do LinkedList:  1.0433351 ms
Tempo médio do ArrayList:   0.59610005 ms
Lista mais rápida: ArrayList
Quantidade de vitórias: ArrayList (19/20)
Razão de desempenho: ArrayList 1.75x mais rápido
```

**Análise:**
O ArrayList foi ligeiramente mais rápido na remoção do último elemento. Embora ambas as operações sejam teoricamente O(1), o ArrayList apresenta menor overhead operacional.

### Exercício 3.2 - Remoção do Último Elemento

**Objetivo:** Avaliar o tempo necessário para remover todos os elementos, sempre removendo o último elemento da lista.

**Metodologia:**
- Número de testes: 20 execuções
- Número de elementos inicial: 100.000 por teste
- Operação: Remoção sequencial do último elemento até esvaziar a lista
- Medição: Tempo total de esvaziamento da lista

**Resultados Experimentais:**
```
Tempo médio do LinkedList:  0.5260298499999999 ms
Tempo médio do ArrayList:   508.2503350999999 ms
Lista mais rápida: LinkedList
Quantidade de vitórias: LinkedList (20/20)
Razão de desempenho: LinkedList 966x mais rápido
```

**Análise:**
O LinkedList apresentou desempenho extraordinariamente superior, sendo aproximadamente 966 vezes mais rápido. Este resultado confirma perfeitamente a teoria: remoção do primeiro elemento em ArrayList requer deslocamento de todos os elementos restantes (O(n²) total), enquanto LinkedList remove apenas o ponteiro do head (O(1)).

---

## Questão 4: Remoção em Posição Aleatória

### Exercício 4.1 - Comparação Entre ArrayList e LinkedList

**Objetivo:** Avaliar o tempo para remover elementos de índices aleatórios até que a lista fique vazia.

**Metodologia:**
- Número de testes: 20 execuções
- Número de elementos inicial: 50.000 por teste
- Operação: Remoção de elemento em índice aleatório até esvaziar a lista
- Medição: Tempo total de esvaziamento da lista

**Resultados Experimentais:**
```
Tempo médio do LinkedList:  1110.01921515 ms
Tempo médio do ArrayList:   68.98278480000002 ms
Lista mais rápida: ArrayList
Quantidade de vitórias: ArrayList (20/20)
Razão de desempenho: ArrayList 16.09x mais rápido
```

**Análise:**
O ArrayList foi significativamente mais rápido, apresentando desempenho cerca de 16 vezes superior. Este resultado contraria a teoria, que prevê complexidade similar (O(n) para ambos) em operações de remoção aleatória.

---

## Questão 5: Acesso Aleatório

### Exercício 5.1 - Comparação Entre ArrayList e LinkedList

**Objetivo:** Avaliar o tempo para realizar acessos a índices aleatórios válidos.

**Metodologia:**
- Número de testes: 20 execuções
- Número de elementos: 100.000 por teste
- Número de acessos: 10.000 por teste
- Operação: Acesso aleatório a elementos (lista.get(índice_aleatório))
- Medição: Tempo total para executar todos os acessos

**Resultados Experimentais:**
```
Tempo médio do LinkedList:  433.51870005 ms
Tempo médio do ArrayList:   0.2048201 ms
Lista mais rápida: ArrayList
Quantidade de vitórias: ArrayList (20/20)
Razão de desempenho: ArrayList 2117x mais rápido
```

**Análise:**
O ArrayList apresentou desempenho excepcional, sendo mais de 2000 vezes mais rápido que o LinkedList. Este resultado confirma perfeitamente a teoria: acesso por índice em ArrayList é O(1), enquanto em LinkedList é O(n) em média.

**Explicação baseada na organização interna:**

**ArrayList:**
- Dados armazenados em array contíguo na memória
- Acesso direto por índice: `array[i]` (O(1) real)
- Cache locality excelente (prefetching automático)
- Operação essencialmente um cálculo de endereço + acesso direto

**LinkedList:**
- Dados dispersos em nós ligados por ponteiros
- Acesso por índice requer travessia: O(n) em média
- Cada acesso envolve dereferenciação de ponteiro
- Possível cache miss em cada passo da travessia

---

## Questão 6: Síntese Geral

### Cenários onde o ArrayList foi mais vantajoso:

1. **Acesso aleatório** (2117x mais rápido)
   - Cenário ideal para ArrayList
   - Confirma teoria O(1) vs O(n)

2. **Inserção em posição aleatória** (38x mais rápido)
   - Contraria teoria completamente
   - Cache locality e JIT optimization decisivos

3. **Remoção em posição aleatória** (16x mais rápido)
   - Mesmo padrão de cache efficiency
   - ArrayList acesso O(1) vs LinkedList O(n)

4. **Remoção do último elemento** (1.75x mais rápido)
   - Ambas O(1), mas ArrayList com menos overhead

5. **Inserção ao final** (equilibrado)
   - Diferença mínima, praticamente equivalente

### Cenários onde o LinkedList foi mais vantajoso:

1. **Remoção do primeiro elemento** (966x mais rápido)
   - Cenário ideal para LinkedList
   - O(1) real vs O(n²) do ArrayList
   - Confirma teoria completamente

2. **Inserção ao final** (1.22x mais rápido - marginal)
   - Evita realocações de memória
   - Diferença insignificante na prática

### Os resultados experimentais confirmaram a teoria esperada?

**Resposta: Parcialmente SIM (50%) e parcialmente NÃO (50%)**

**Confirmações teóricas:**
- ✅ Remoção do início: LinkedList O(1) vs ArrayList O(n²)
- ✅ Acesso aleatório: ArrayList O(1) vs LinkedList O(n)

**Divergências teóricas:**
- ❌ Inserção aleatória: ArrayList 38x mais rápido (esperava LinkedList)
- ❌ Remoção aleatória: ArrayList 16x mais rápido (esperava similar)

### Quais fatores práticos influenciaram os resultados?

1. **Cache de CPU (FATOR DOMINANTE):**
   - ArrayList: dados contíguos → cache hits frequentes
   - LinkedList: ponteiros aleatórios → cache misses frequentes
   - Impacto: diferenças de 10x a 2000x

2. **Otimização JIT (Just-In-Time Compilation):**
   - Loops em ArrayList compilados para código nativo otimizado
   - LinkedList: lógica mais complexa (dereferenciações)
   - System.arraycopy() implementado em código nativo

3. **Overhead de Memória:**
   - ArrayList: alocação única, realocações raras
   - LinkedList: múltiplas alocações pequenas (cada nó)
   - LinkedList: maior pressão no garbage collector

4. **Localidade Espacial:**
   - ArrayList: acesso sequencial otimizado
   - LinkedList: saltos aleatórios na memória

5. **Tamanho dos Dados:**
   - Com 100.000 elementos, diferenças assintóticas aparecem claramente
   - Cache effects amplificados nesta escala