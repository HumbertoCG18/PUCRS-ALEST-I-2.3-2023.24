package Aula_15_08_2023;

public class InvertRecursivo {

    public static void inverterVetor(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            // Troca os elementos nas posições inicio e fim
            int temp = vetor[inicio];
            vetor[inicio] = vetor[fim];
            vetor[fim] = temp;
            
            // Chama a função recursivamente para o próximo par de elementos
            inverterVetor(vetor, inicio + 1, fim - 1);
        }
    }

    public static void main(String[] args) {
        int[] vetor = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        System.out.println("Vetor original:");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        
        inverterVetor(vetor, 0, vetor.length - 1);
        
        System.out.println("\nVetor invertido:");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
    }
}
