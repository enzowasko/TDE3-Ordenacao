# TDE3-Ordenacao
# Comparação de Algoritmos de Ordenação em Java

Aluno: Enzo Wasko Amorim;

Matéria: Resolução de Problemas Estruturados em Computação;

Professor: Andrey Cabral Meira;

---
## Introdução
Este projeto compara o desempenho de **seis algoritmos de ordenação** implementados manualmente em Java, **sem o uso de funções ou estruturas prontas** da API.  
Foram analisados os seguintes métodos:

- **Comb Sort**
- **Gnome Sort**
- **Bubble Sort (com flag de parada)**
- **Selection Sort**
- **Cocktail Sort**
- **Bucket Sort (implementado manualmente com vetores fixos)**

##  Regras da Implementação

- Nenhuma estrutura pronta foi utilizada (`List`, `ArrayList`, `Vector`, etc.).
- Nenhuma função da API Java foi usada (`Arrays.sort`, `Collections`, etc.).
- Nenhum uso de `try/catch`, `StringBuilder` ou exceções.
- Todos os algoritmos trabalham com vetores (`int[]`) e laços manuais.
- O **Bucket Sort** utiliza apenas vetores simples, com ordenação interna via **Insertion Sort** manual.

---

## Resultados — Vetor 1 (Aleatório)

| Algoritmo           | Trocas | Iterações |
|----------------------|:------:|:----------:|
| Comb Sort            | 22     | 129        |
| Gnome Sort           | 78     | 176        |
| Bubble Sort (flag)   | 78     | 180        |
| Selection Sort       | **18**     | 190        |
| Cocktail Sort        | 78     | 154        |
| **Bucket Sort**      | 30 | **78**    |

**Melhores resultados:**
- 🥇 **Menos trocas:** Selection Sort (18)
- 🥈 **Menos iterações:** Bucket Sort (94)

---

## Resultados — Vetor 2 (Ordenado)

| Algoritmo           | Trocas | Iterações |
|----------------------|:------:|:----------:|
| Comb Sort            | 0      | 110        |
| Gnome Sort           | 0      | 20         |
| Bubble Sort (flag)   | 0      | 19         |
| Selection Sort       | 0      | 190        |
| Cocktail Sort        | 0      | **19**         |
| **Bucket Sort**      | 0 | 59     |

**Melhores resultados:**
- 🥇 **Empate em trocas:** todos (0)
- 🥇 **Menos iterações:** Bubble Sort (flag) e Cocktail Sort (19)

---

## Resultados — Vetor 3 (Decrescente)

| Algoritmo           | Trocas | Iterações |
|----------------------|:------:|:----------:|
| Comb Sort            | 18     | **129**        |
| Gnome Sort           | 190    | 400        |
| Bubble Sort (flag)   | 190    | 190        |
| Selection Sort       | **10**     | 190        |
| Cocktail Sort        | 190    | 190        |
| **Bucket Sort**      | 90 | 133    |

**Melhores resultados:**
- 🥇 **Menos trocas:** Selection Sort (10)
- 🥈 **Menos iterações:** Comb Sort (129)

---

## Conclusão Geral

| Critério | Melhor Algoritmo |
|-----------|------------------|
| **Eficiência em vetores aleatórios** | 🥇 Bucket Sort |
| **Eficiência em vetores já ordenados** | 🥇 Bubble Sort (flag) / Cocktail Sort |
| **Eficiência em vetores decrescentes** | 🥇 Selection Sort |
| **Desempenho médio geral** | 🥇 Bucket Sort (ótimo equilíbrio entre trocas e iterações) |
