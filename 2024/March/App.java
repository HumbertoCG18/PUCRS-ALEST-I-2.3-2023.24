package March;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        // Tamanhos de entrada
        int[] sizes = {500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000, 5500, 6000, 6500, 7000};

        // Dados para os algoritmos
        long[][] operationCounts = new long[4][sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            int[] data = generateRandomArray(sizes[i]);
            operationCounts[0][i] = BubbleSort.bubbleSort(data.clone());
            operationCounts[1][i] = InsertionSort.insertionSort(data.clone());
            operationCounts[2][i] = MergeSort.mergeSort(data.clone());
            operationCounts[3][i] = QuickSort.quickSort(data.clone());
        }

        String filePath = "2024/March/results.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            // Escrever os nomes dos algoritmos na primeira linha
            writer.write("Bubble,Insertion,Merge,Quick\n");

            // Escrever os resultados para cada tamanho de entrada
            for (int j = 0; j < sizes.length; j++) {
                for (int i = 0; i < 4; i++) {
                    writer.write(operationCounts[i][j] + "");
                    if (i < 3) {
                        writer.write(",");
                    } else {
                        writer.write("\n");
                    }
                }
            }
            System.out.println("Arquivo CSV gerado com sucesso em: " + filePath);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
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
}
