#### <center>BeeCrowd | 1633</center> ####

# <center>Estatística Hexa</center> #

Dada uma sequência de inteiros positivos em hexadecimal, por exemplo, $ S = [9af47c0b, 2545557, ff6447979] $, definimos soma(S) como sendo a soma de todos os elementos de S. Considere agora uma certa permutação dos **16 dígitos** hexadecimais, por exemplo, $ p = [4, 9, 5, a, 0, c, f, 3, d, 7, 8, b, 1, 2, 6, e]$. A partir da sequência base S, podemos definir uma sequência transformada $S[4]$ , que é obtida pela remoção de todas as ocorrêcias do dígito hexadecimal 4 de todos os inteiros em S, $S[4] = [9af7c0b, 255557, ff67979]$. Em seguida, podemos remover o dígito 9 e obter $S[4,9] = [af7c0b, 255557, ff677]$. Seguindo a ordem dos dígitos na permutação p, podemos definir dessa forma 16 sequências: $S[4] , S[4,9] , S[4,9,5] ,...,S[4,9,5,a,0,c,f,3,d,7,8,b,1,2,6,e]$. Estamos interessados em somar todos os elementos dessas 16 sequências:

<center> 

$total(S, p) = soma(S[4]) + soma(S[4,9]) + soma(S[4,9,5]) + ··· + soma(S[4,9,5,a,0,c,f,3,d,7,8,b,1,2,6,e])$

</center>

Claramente, esse total depende da permutação **p** usada na remoção sucessiva. Dada uma sequência de **N** inteiros positivos em hexadecimal, seu programa deve computar, considerando todas as possíveis permutações dos 16 dígitos hexadecimais: o total mínimo, o total máximo e o somatório dos totais de todas as permutações. Para o somatório dos totais de todas as permutações, imprima o resultado módulo 3b9aca07 (109 + 7 na base 10).

# Entrada
A primeira linha da entrada contém um inteiro **N**,  1 ≤ **N** ≤ 3f, representando o tamanho da sequência. As **N&** linhas seguintes contêm, cada uma, um inteiro positivo **P**, 0 ≤ **P** ≤ fffffffff, definindo a sequência inicial **S** de inteiros. Todos os números na entrada estão em hexadecimal, com letras minúsculas.

# Saída
Seu programa deve produzir uma única linha na saída contendo três inteiros positivos, em hexadecimal com letras minúsculas, representando o total mínimo, o total máximo e o somatório dos totais considerando todas as permutações possíveis dos 16 dígitos hexadecimais.

<center>

# Resolução

</center>

O problema se resume a gerenciar processos que chegam a um sistema de forma concorrente, onde cada processo tem um tempo de início (tempo de requisição) e um tempo de execução (quantos ciclos de processamento ele precisa). O objetivo é calcular o tempo total de espera para todos os processos.

1. Leitura da Entrada:
    - O número total de casos de teste é lido. Cada caso de teste começa com a leitura de um número inteiro N, que representa o número de processos.

1. Leitura dos Processos:
    - Para cada caso de teste, lemos N linhas, onde cada linha contém dois inteiros: o tempo de início (tempo de requisição) e o tempo de execução do processo.

1. Ordenação dos Processos:
    - Os processos são ordenados com base no tempo de início (tempo de requisição). Isso garante que os processos sejam processados na ordem em que chegaram.

1. Simulação da Execução:
    - Inicializamos uma fila de prioridade (ou heap) para armazenar os processos pendentes. A fila de prioridade é classificada com base no tempo de execução (ciclos de processamento) dos processos, de modo que o processo com menor tempo de execução fica no topo da fila. 
    - Iteramos sobre os processos ordenados e simulamos sua execução.
    - Verificamos se o tempo atual do sistema é menor que o tempo de início do processo. Se for, significa que o sistema estava ocioso, e adicionamos o tempo de espera ao tempo total de espera.
    - Se houver processos na fila de prioridade, escolhemos o próximo processo com o menor tempo de execução e o executamos. Atualizamos o tempo atual do sistema.
    - Repetimos o processo até que não haja mais processos na fila de prioridade ou até que todos os processos tenham sido executados.

1. Cálculo do Tempo de Espera:
    - Após a simulação, teremos o tempo total de espera acumulado para todos os processos.

1. Impressão da Saída: 
    - Imprimimos o tempo total de espera para o caso de teste atual.

1. Repetição:
    - O processo é repetido para todos os casos de teste.



