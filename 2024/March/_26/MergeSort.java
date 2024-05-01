package March._26;
import java.util.Random;

public class MergeSort {
    public static long mergeSort(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static long mergeSort(int arr[], int l, int r) {
        long operationCount = 0;
        if (l < r) {
            int m = (l + r) / 2;
            operationCount += mergeSort(arr, l, m);
            operationCount += mergeSort(arr, m + 1, r);
            operationCount += merge(arr, l, m, r);
        }
        return operationCount;
    }

    private static long merge(int arr[], int l, int m, int r) {
        long operationCount = 0;
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            operationCount++; // Contagem de operações
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            operationCount++; // Contagem de operações
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            operationCount++; // Contagem de operações
        }
        return operationCount;
    }

    public static void main(String args[]) {
        Random r = new Random();
        int MAX = 10000;
        int[] data = new int[MAX];
        for (int i = 0; i < data.length; i++)
            data[i] = r.nextInt(data.length * 10);

        long operationCount = mergeSort(data.clone());
        System.out.println("Número de operações do Merge Sort: " + operationCount);
    }
}