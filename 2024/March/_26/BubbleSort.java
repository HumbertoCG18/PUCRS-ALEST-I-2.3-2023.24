package March._26;
import java.util.Random;

public class BubbleSort {
    public static long bubbleSort(int[] arr) {
        long operationCount = 0;
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                operationCount++; // Contagem de operações
                if (arr[j] > arr[j + 1]) {
                    // troca arr[j] e arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Se não houve troca nesta iteração, o array já está ordenado
            if (!swapped) {
                break;
            }
        }
        return operationCount;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int MAX = 10000;
        int[] data = new int[MAX];
        for (int i = 0; i < data.length; i++)
            data[i] = r.nextInt(data.length * 10);

        long operationCount = bubbleSort(data.clone());
        System.out.println("Número de operações do Bubble Sort: " + operationCount);
    }
}