import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // quantidade de casos

        for (int q = 0; q < n; q++) {
            int m = sc.nextInt(); // quantidade de endereços-base na tabela
            int c = sc.nextInt(); // quantidade de chaves a serem armazenadas
            sc.nextLine(); // Consume the newline after reading an integer

            String[] dados = sc.nextLine().split(" "); // Lê a linha e divide as chaves

            String[] keys = new String[m];
            Arrays.fill(keys, "");

            for (String x : dados) {
                int key = Integer.parseInt(x);
                int index = key % m;
                keys[index] += " -> " + key;
            }

            for (int i = 0; i < m; i++) {
                System.out.println(i + keys[i] + " -> \\");
            }
            if (q < n - 1)
                System.out.println();
        }
        sc.close();
    }
}
