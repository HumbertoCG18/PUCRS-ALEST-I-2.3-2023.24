package April._25__2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOperations {
    
    // 1. Calcular a soma dos elementos de uma lista
    public static int calcularSoma(List<Integer> lista) {
        int soma = 0;
        for (int elemento : lista) {
            soma += elemento;
        }
        return soma;
    }
    
    // 2. Calcular a média dos elementos de uma lista
    public static double calcularMedia(List<Integer> lista) {
        if (lista.isEmpty()) return 0.0;
        return (double) calcularSoma(lista) / lista.size(); //Divide a soma pelo tamanho da lista
    }
    
    // 3. Encontrar o menor e o maior elemento de uma lista
    public static void encontrarMinMax(List<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }
        int min = Collections.min(lista);
        int max = Collections.max(lista);
        System.out.println("Menor elemento: " + min);
        System.out.println("Maior elemento: " + max);
    }
    
    // 4. Encontrar o índice do último elemento que é menor que um valor fornecido
    public static int encontrarUltimoMenor(List<Integer> lista, int valor) {
        for (int i = lista.size() - 1; i >= 0; i--) {
            if (lista.get(i) < valor) {
                return i;
            }
        }
        return -1; // Se nenhum elemento for menor que o valor fornecido
    }
    
    // 5. Encontrar a soma dos elementos em uma lista entre dois índices fornecidos
    public static int calcularSomaEntreIndices(List<Integer> lista, int indiceInicial, int indiceFinal) {
        int soma = 0;
        for (int i = indiceInicial; i <= indiceFinal; i++) {
            soma += lista.get(i);
        }
        return soma;
    }
    
    // 6. Encontrar o segundo maior elemento em uma lista
    public static int encontrarSegundoMaior(List<Integer> lista) {
        if (lista.size() < 2) {
            System.out.println("Lista tem menos de dois elementos.");
            return -1;
        }
        Collections.sort(lista);
        return lista.get(lista.size() - 2);
    }
    
    // 7. Verificar se uma lista está ordenada
    public static int verificarOrdenacao(List<Integer> lista) {
        boolean crescente = true;
        boolean decrescente = true;
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i) < lista.get(i - 1)) {
                crescente = false;
            }
            if (lista.get(i) > lista.get(i - 1)) {
                decrescente = false;
            }
        }
        if (crescente) return 1;
        if (decrescente) return -1;
        return 0;
    }
    
    // 8. Encontrar o número de inversões em uma lista
    public static int contarInversoes(List<Integer> lista) {
        int inversoes = 0;
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i) > lista.get(j)) {
                    inversoes++;
                }
            }
        }
        return inversoes;
    }
    
    // 9. Remover todos os elementos repetidos adjacentes em uma lista
    public static void removerRepetidosAdjacentes(List<Integer> lista) {
        List<Integer> novaLista = new ArrayList<>();
        for (int i = 0; i < lista.size() - 1; i++) {
            if (!lista.get(i).equals(lista.get(i + 1))) {
                novaLista.add(lista.get(i));
            }
        }
        novaLista.add(lista.get(lista.size() - 1));
        lista.clear();
        lista.addAll(novaLista);
    }
    
    // 10. Inserir um novo elemento na lista de forma ordenada
    public static void inserirOrdenado(List<Integer> lista, int elemento) {
        int index = Collections.binarySearch(lista, elemento);
        if (index < 0) {
            index = -(index + 1);
        }
        lista.add(index, elemento);
    }
    
    // 11. Imprimir os elementos de uma lista na ordem normal e na ordem inversa
    public static void imprimirNormalEInversa(List<Integer> lista) {
        System.out.println("Ordem Normal:");
        for (int elemento : lista) {
            System.out.print(elemento + " ");
        }
        System.out.println();
        System.out.println("Ordem Inversa:");
        for (int i = lista.size() - 1; i >= 0; i--) {
            System.out.print(lista.get(i) + " ");
        }
        System.out.println();
    }
    
    // 12. Inverter uma lista
    public static void inverterLista(List<Integer> lista) {
        Collections.reverse(lista);
    }
    
    // 13. Remover todos os elementos duplicados de uma lista
    public static void removerDuplicados(List<Integer> lista) {
        List<Integer> novaLista = new ArrayList<>();
        for (int elemento : lista) {
            if (!novaLista.contains(elemento)) {
                novaLista.add(elemento);
            }
        }
        lista.clear();
        lista.addAll(novaLista);
    }
    
    // 14. Ordenar uma lista em ordem crescente ou decrescente
    public static void ordenarLista(List<Integer> lista, boolean crescente) {
        if (crescente) {
            Collections.sort(lista);
        } else {
            Collections.sort(lista, Collections.reverseOrder());
        }
    }
    
    // 15. Dividir uma lista em duas com base em um valor de referência
    public static void dividirLista(List<Integer> lista, int referencia) {
        List<Integer> menores = new ArrayList<>();
        List<Integer> maioresOuIguais = new ArrayList<>();
        for (int elemento : lista) {
            if (elemento < referencia) {
                menores.add(elemento);
            } else {
                maioresOuIguais.add(elemento);
            }
        }
        System.out.println("Elementos menores que " + referencia + ": " + menores);
        System.out.println("Elementos maiores ou iguais a " + referencia + ": " + maioresOuIguais);
    }
    
    // 16. Dividir uma lista em duas partes, uma com números pares e outra com números ímpares
    public static void dividirParesEImpares(List<Integer> lista) {
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();
        for (int elemento : lista) {
            if (elemento % 2 == 0) {
                pares.add(elemento);
            } else {
                impares.add(elemento);
            }
        }
        System.out.println("Números Pares: " + pares);
        System.out.println("Números Ímpares: " + impares);
    }
    
    public static void main(String[] args) {
        // Exemplo de uso das funções
        List<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(1);
        lista.add(5);
        lista.add(2);
        lista.add(4);
        
        System.out.println("Soma: " + calcularSoma(lista));
        System.out.println("Média: " + calcularMedia(lista));

        encontrarMinMax(lista);

        System.out.println("Índice do último elemento menor que 3: " + encontrarUltimoMenor(lista, 3));
        System.out.println("Soma entre índices 1 e 3: " + calcularSomaEntreIndices(lista, 1, 3));
        System.out.println("Segundo maior elemento: " + encontrarSegundoMaior(lista));
        System.out.println("Ordenação: " + verificarOrdenacao(lista));
        System.out.println("Número de inversões: " + contarInversoes(lista));
        
        
        System.out.println("Lista sem elementos repetidos adjacentes: " + lista);
        removerRepetidosAdjacentes(lista);
        
        System.out.println("Lista com inserção ordenada: " + lista);
        inserirOrdenado(lista, 3);
        imprimirNormalEInversa(lista);
        
        System.out.println("Lista invertida: " + lista);
        inverterLista(lista);
    
        System.out.println("Lista sem elementos duplicados: " + lista);
        removerDuplicados(lista);
        
        System.out.println("Lista ordenada crescente: " + lista);
        ordenarLista(lista, true);
        
        System.out.println("Lista ordenada decrescente: " + lista);
        ordenarLista(lista, false);

        dividirLista(lista, 3);
        dividirParesEImpares(lista);
    }
}
