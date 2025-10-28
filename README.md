# TDE3-Ordenacao
#🔹Comparação de Algoritmos de Ordenação em Java

Aluno: Enzo Wasko Amorim;

Matéria: Resolução de Problemas Estruturados em Computação;

Professor: Andrey Cabral Meira;


Este projeto tem como objetivo comparar o desempenho de diferentes algoritmos de ordenação em termos de **trocas** e **iterações**.  
Foram utilizados cinco algoritmos implementados manualmente (sem uso de funções prontas do Java):

- Comb Sort  
- Gnome Sort  
- Bubble Sort (com flag de otimização)  
- Selection Sort  
- Cocktail Sort  

# 🔹 Resultados Obtidos
## Vetor 1 (Aleatório)
| Algoritmo          | Trocas | Iterações |
| ------------------ | :----: | :-------: |
| Comb Sort          |   22   |    129    |
| Gnome Sort         |   78   |    176    |
| Bubble Sort (flag) |   78   |    180    |
| Selection Sort     |   18   |    190    |
| Cocktail Sort      |   78   |    154    |

## Vetor 2 (Ordenado)
| Algoritmo          | Trocas | Iterações |
| ------------------ | :----: | :-------: |
| Comb Sort          |    0   |    110    |
| Gnome Sort         |    0   |     20    |
| Bubble Sort (flag) |    0   |     19    |
| Selection Sort     |    0   |    190    |
| Cocktail Sort      |    0   |     19    |

## Vetor 3 (Decrescente)
| Algoritmo          | Trocas | Iterações |
| ------------------ | :----: | :-------: |
| Comb Sort          |   18   |    129    |
| Gnome Sort         |   190  |    400    |
| Bubble Sort (flag) |   190  |    190    |
| Selection Sort     |   10   |    190    |
| Cocktail Sort      |   190  |    190    |

# 🔹Conclusões

- Selection Sort realiza poucas trocas, mas é lento em iterações.

- Bubble Sort e Gnome Sort têm muitas trocas, principalmente em vetores inversos.

- Comb Sort mostra boa eficiência geral, reduzindo trocas em casos aleatórios.

- Cocktail Sort tem desempenho semelhante ao Bubble, porém com pequenas otimizações.
