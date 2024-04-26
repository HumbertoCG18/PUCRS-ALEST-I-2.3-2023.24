package March;
import java.util.Random;

public class InsertionSort {
    public static long insertionSort(int[] arr) {
        long operationCount = 0;
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            // Move os elementos de arr[0..i-1] que são maiores que key
            // para uma posição à frente de suas posições atuais
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                operationCount++; // Contagem de operações
            }
            arr[j + 1] = key;
        }
        return operationCount;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int MAX = 10000;
        int[] data = new int[MAX];
        for (int i = 0; i < data.length; i++)
            data[i] = r.nextInt(data.length * 10);

        long operationCount = insertionSort(data.clone());
        System.out.println("Número de operações do Insertion Sort: " + operationCount);
    }
}