public class UniaoListas {

    /**
     * Define a estrutura do nó para a lista encadeada.
     * Sendo uma classe aninhada estática, ela está contida dentro de UniaoListas.
     */
    static class No {
        int valor;
        No proximo;

        No(int v) {
            this.valor = v;
            this.proximo = null;
        }
    }

    /**
     * Recebe duas listas lineares de inteiros (L1 e L2), ordenadas e sem repetições,
     * e retorna uma nova lista que é a união ordenada das duas.
     *
     * @param l1 Primeiro nó (cabeça) da lista L1.
     * @param l2 Primeiro nó (cabeça) da lista L2.
     * @return O primeiro nó (cabeça) da nova lista unida.
     */
    public static No uniao(No l1, No l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        No cabecaResultado = null; // Cabeça da nova lista
        No caudaResultado = null;  // Último nó da nova lista

        // Ponteiros para percorrer L1 e L2
        No ponteiro1 = l1;
        No ponteiro2 = l2;

        // Define o primeiro elemento da lista resultante
        if (ponteiro1.valor < ponteiro2.valor) {
            cabecaResultado = new No(ponteiro1.valor);
            ponteiro1 = ponteiro1.proximo;
        } else if (ponteiro2.valor < ponteiro1.valor) {
            cabecaResultado = new No(ponteiro2.valor);
            ponteiro2 = ponteiro2.proximo;
        } else { // Valores são iguais, adiciona apenas um
            cabecaResultado = new No(ponteiro1.valor);
            ponteiro1 = ponteiro1.proximo;
            ponteiro2 = ponteiro2.proximo;
        }
        caudaResultado = cabecaResultado;

        //Recursao
        // Percorre ambas as listas enquanto houver elementos em ambas
        while (ponteiro1 != null && ponteiro2 != null) {
            if (ponteiro1.valor < ponteiro2.valor) {
                // Adiciona o valor de L1 se não for repetido
                if (caudaResultado.valor != ponteiro1.valor) {
                    caudaResultado.proximo = new No(ponteiro1.valor);
                    caudaResultado = caudaResultado.proximo;
                }
                ponteiro1 = ponteiro1.proximo;
            } else if (ponteiro2.valor < ponteiro1.valor) {
                // Adiciona o valor de L2 se não for repetido
                if (caudaResultado.valor != ponteiro2.valor) {
                    caudaResultado.proximo = new No(ponteiro2.valor);
                    caudaResultado = caudaResultado.proximo;
                }
                ponteiro2 = ponteiro2.proximo;
            } else { // Valores são iguais
                // Adiciona o valor se não for uma repetição do último adicionado
                if (caudaResultado.valor != ponteiro1.valor) {
                    caudaResultado.proximo = new No(ponteiro1.valor);
                    caudaResultado = caudaResultado.proximo;
                }
                ponteiro1 = ponteiro1.proximo;
                ponteiro2 = ponteiro2.proximo;
            }
        }

        // Adiciona os elementos restantes de L1, se houver
        while (ponteiro1 != null) {
            if (caudaResultado.valor != ponteiro1.valor) {
                caudaResultado.proximo = new No(ponteiro1.valor);
                caudaResultado = caudaResultado.proximo;
            }
            ponteiro1 = ponteiro1.proximo;
        }

        // Adiciona os elementos restantes de L2, se houver
        while (ponteiro2 != null) {
            if (caudaResultado.valor != ponteiro2.valor) {
                caudaResultado.proximo = new No(ponteiro2.valor);
                caudaResultado = caudaResultado.proximo;
            }
            ponteiro2 = ponteiro2.proximo;
        }

        return cabecaResultado;
    }

    // Função auxiliar para imprimir a lista (para teste)
    public static void imprimirLista(No no) {
        if (no == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        No atual = no;
        while (atual != null) {
            System.out.print(atual.valor + (atual.proximo != null ? ", " : ""));
            atual = atual.proximo;
        }
        System.out.println("]");
    }

    // Método principal para demonstrar o uso
    public static void main(String[] args) {
        // Criando a Lista 1: [1, 3, 5, 8]
        No l1 = new No(1);
        l1.proximo = new No(3);
        l1.proximo.proximo = new No(5);
        l1.proximo.proximo.proximo = new No(8);

        // Criando a Lista 2: [2, 3, 4, 8, 10]
        No l2 = new No(2);
        l2.proximo = new No(3);
        l2.proximo.proximo = new No(4);
        l2.proximo.proximo.proximo = new No(8);
        l2.proximo.proximo.proximo.proximo = new No(10);
        
        System.out.print("Lista 1: ");
        imprimirLista(l1);

        System.out.print("Lista 2: ");
        imprimirLista(l2);

        // Realizando a união
        No listaUnida = uniao(l1, l2);

        // Imprimindo o resultado
        System.out.print("Resultado da Uniao: ");
        imprimirLista(listaUnida); // Saída esperada: [1, 2, 3, 4, 5, 8, 10]
    }
}