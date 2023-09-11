<style>
blue {
  color: lightblue;
}

red {
  color: red;
}

green {
  color: lightgreen;
}

yellow {
  color: yellow;
}

orange {
  color: orange;
}

grey {
  color: grey;
}
</style>



#### <center>BeeCrowd | 1340</center> ####

# <center>Eu Posso Adivinhar a Estrutura de Dados!</center> #

Existe uma estrutura de dados do tipo sacola, suportando duas operações:

1 x
Jogue um elemento x na sacola.

2
Tire um elemento da sacola.

Dada uma sequencia de operações que retornam valores, você vai adivinhar a estrutura de dados. É uma pilha (último-dentro, primeiro-fora), uma fila (primeiro-dentro, primeiro-fora), uma fila de prioridade (sempre tire os elementos grandes por primeiro) ou qualquer outra coisa que você dificilmente consegue imaginar!

## Entrada
Existem muitos casos de testes. Cada caso de teste começa com a linha contando um único inteiro **n** (1 <= **n** <= 1000). Cada uma das seguintes **n** linhas é um comando do tipo 1, ou um número inteiro 2, seguido de um número inteiro **x**. Isso significa que depois de executar um comando do tipo 2, obtemos um elemento **x** sem erros. O valor de **x** é sempre um número inteiro, positivo e não maior do que 100. O final da entrada é determinado pelo final do arquivo (EOF). O tamanho do arquivo de entrada não excede 1MB.

## Saída
Para cada caso de teste, mostre um dos seguintes:

### <green>Stack</green> 
É definitivamente uma pilha.

### <yellow>Queue</yellow>
É definitivamente uma fila.

### <orange>Priority queue</orange>
É definitivamente uma fila de prioridade.

### <red>Impossible</red>
Não pode ser uma pilha, uma fila ou uma fila de prioridade.

### <grey>Not sure</grey>
Pode ser mais de uma das três estruturas mencionadas acima.

