package _1256;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Quantidade de casos de teste

        for (int i = 0; i < N; i++) {
            int M = scanner.nextInt(); // Quantidade de endereços-base na tabela
            int C = scanner.nextInt(); // Quantidade de chaves a serem armazenadas

            List<List<Integer>> tabela = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                tabela.add(new ArrayList<>());
            }

            for (int j = 0; j < C; j++) {
                int chave = scanner.nextInt();
                int endereco = chave % M;
                tabela.get(endereco).add(chave);
            }

            // Imprimir saída
            for (int j = 0; j < M; j++) {
                System.out.print(j + " -> ");
                for (int chave : tabela.get(j)) {
                    System.out.print(chave + " -> ");
                }
                System.out.println("\\");
            }

            if (i < N - 1) {
                System.out.println();
            }
        }

        scanner.close();
    }
}

