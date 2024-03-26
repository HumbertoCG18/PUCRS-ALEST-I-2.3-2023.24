package March;
import java.util.Random;

public class QuickSort {
    public static long quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private static long quickSort(int[] arr, int low, int high) {
        long operationCount = 0;
        if (low < high) {
            int pi = partition(arr, low, high);
            operationCount += quickSort(arr, low, pi - 1);
            operationCount += quickSort(arr, pi + 1, high);
        }
        return operationCount;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int MAX = 10000;
        int[] data = new int[MAX];
        for (int i = 0; i < data.length; i++)
            data[i] = r.nextInt(data.length * 10);

        long operationCount = quickSort(data.clone());
        System.out.println("Número de operações do Quick Sort: " + operationCount);
    }
}