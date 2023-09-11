#### <center>BeeCrowd | 1256</center> ####

# <center>Tabelas Hash</center> #

As tabelas Hash, também conhecidas como tabelas de dispersão, armazenam elementos com base no valor absoluto de suas chaves e em técnicas de tratamento de colisões. Para o cálculo do endereço onde deve ser armazenada uma determinada chave, utiliza-se uma função denominada função de dispersão, que transforma a chave em um dos endereços disponíveis na tabela.

Suponha que uma aplicação utilize uma tabela de dispersão com 13 endereços-base (índices de 0 a 12) e empregue a função de dispersão $ h(x) = x mod 13 $, em que x representa a chave do elemento cujo endereço-base deve ser calculado.

Se a chave x for igual a 49, a função de dispersão retornará o valor 10, indicando o local onde esta chave deverá ser armazenada. Se a mesma aplicação considerar a inserção da chave 88, o cálculo retornará o mesmo valor 10, ocorrendo neste caso uma colisão. O Tratamento de colisões serve para resolver os conflitos nos casos onde mais de uma chave é mapeada para um mesmo endereço-base da tabela. Este tratamento pode considerar, ou o recálculo do endereço da chave ou o encadeamento externo ou exterior.

O professor gostaria então que você o auxiliasse com um programa que calcula o endereço para inserções de diversas chaves em algumas tabelas, com funções de dispersão e tratamento de colisão por encadeamento exterior.

## Entrada
A entrada contém vários casos de teste. A primeira linha de entrada contém um inteiro N indicando a quantidade de casos de teste. Cada caso de teste é composto por duas linhas. A primeira linha contém um valor **M** (1 ≤ **M** ≤ 100) que indica a quantidade de endereços-base na tabela (normalmente um número primo) seguido por um espaço e um valor **C** (1 ≤ **C** ≤ 200) que indica a quantidade de chaves a serem armazenadas. A segunda linha contém cada uma das chaves (com valor entre 1 e 200), separadas por um espaço em branco. 

## Saída
A saída deverá ser impressa conforme os exemplos fornecidos abaixo, onde a quantidade de linhas de cada caso de teste é determinada pelo valor de M. Uma linha em branco deverá separar dois conjuntos de saída.

<br>
<br>
<center> 

# Resolução:
</center>


O objetivo deste problema é simular a inserção de chaves em tabelas de dispersão usando uma função de dispersão e tratamento de colisões por encadeamento exterior.

## Entrada: 
- A entrada começa com um inteiro N que representa a quantidade de casos de teste.
- Para cada caso de teste, temos duas linhas:
    1. A primeira linha contém dois inteiros M e C, onde M é a quantidade de endereços-base na tabela e C é a quantidade de chaves a serem armazenadas.
    1. A segunda linha contém C inteiros, que são as chaves a serem inseridas.

## Saída:
- Para cada caso de teste, a saída deve ser a representação da tabela de dispersão após a inserção das chaves, conforme o formato especificado.

## Solução: 
A solução deste problema envolve a criação de uma tabela de dispersão representada por uma lista de listas, onde cada lista interna representa uma entrada na tabela. Aqui estão os passos da solução:

1. Ler o número de casos de teste (N).
1. Para cada caso de teste: 
    1. Ler M e C, o número de endereços-base na tabela e o número de chaves a serem inseridas, respectivamente.
    1. Inicializar a tabela de dispersão como uma lista de M listas vazias, onde cada lista representa um endereço na tabela.
    1. Para cada chave a ser inserida:
        1. Calcular o endereço na tabela usando a função de dispersão (chave % M).
        1. Adicionar a chave à lista correspondente na tabela de dispersão.
    1. Imprimir a saída de acordo com o formato especificado. Para cada endereço na tabela, imprimir o endereço seguido das chaves associadas a ele, separadas por " -> ", terminando com "". Inserir uma linha em branco entre dois conjuntos de saída, conforme necessário.

## Explicação da Saída: 
A saída do programa representa como as chaves estão distribuídas nos endereços da tabela de dispersão após a inserção. Cada linha começa com o número do endereço na tabela, seguido por uma seta "->" e as chaves que foram mapeadas para esse endereço. O "" no final de cada linha indica o final da lista de chaves para aquele endereço.

## Exemplo: 
- Suponha que temos 2 casos de teste:
    - No primeiro caso, temos M=13 e C=5, com as chaves 49, 88, 23, 90 e 44.
    - No segundo caso, temos M=7 e C=4, com as chaves 18, 29, 35 e 60.

```
0 -> \
1 -> 49 -> \
2 -> 90 -> \
3 -> 23 -> \
4 -> \
5 -> \
6 -> \
7 -> \
8 -> \
9 -> 44 -> \
10 -> 88 -> \
11 -> \
12 -> \

0 -> \
1 -> \
2 -> 18 -> 60 -> \
3 -> 29 -> \
4 -> 35 -> \
5 -> \
6 -> \
```

