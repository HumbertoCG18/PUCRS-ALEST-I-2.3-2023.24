package March;
import java.util.Random;

public class App{
    public static void main(String[] args) {
        // Tamanhos de entrada
        int[] sizes = {500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000};

        // Dados para os algoritmos
        long[][] operationCounts = new long[4][sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            int[] data = generateRandomArray(sizes[i]);
            operationCounts[0][i] = BubbleSort.bubbleSort(data.clone());
            operationCounts[1][i] = InsertionSort.insertionSort(data.clone());
            operationCounts[2][i] = MergeSort.mergeSort(data.clone());
            operationCounts[3][i] = QuickSort.quickSort(data.clone());
        }

        // Imprimir os resultados
        for (int i = 0; i < 4; i++) {
            System.out.print(getAlgorithmName(i) + ": ");
            for (int j = 0; j < sizes.length; j++) {
                System.out.print(operationCounts[i][j] + "\t");
            }
            System.out.println(); // Adiciona uma quebra de linha após imprimir os resultados para cada algoritmo
        }
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10);
        }
        return array;
    }

    private static String getAlgorithmName(int index) {
        switch (index) {
            case 0:
                return "Bubble Sort";
            case 1:
                return "Insertion Sort";
            case 2:
                return "Merge Sort";
            case 3:
                return "Quick Sort";
            default:
                return "Unknown";
        }
    }
}