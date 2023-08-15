package Aula_15082023;

public class SomaRecursivo{

    // Função recursiva para somar os elementos de um vetor
    public static int somaVetorRecursivo(int[] vetor, int index) {
        if (index < 0) {
            return 0; // Condição de parada: índice negativo, retorna zero
        } else {
            return vetor[index] + somaVetorRecursivo(vetor, index - 1); // Chamada recursiva
        }
    }

    public static void main(String[] args) {
        int[] vetor = { 5, 3, 8, 2, 1 };
        int resultado = somaVetorRecursivo(vetor, vetor.length - 1);
        System.out.println("A soma dos elementos do vetor é: " + resultado);
    }
}
