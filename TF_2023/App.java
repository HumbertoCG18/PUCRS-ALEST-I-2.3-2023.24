import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LinkedList<Palavra> lista = new LinkedList<>();
        List<String> listaPesquisa = new LinkedList<>();
        WordTree arvore = new WordTree();
        try (Scanner input = new Scanner(System.in)) {
            String aux[];

            Path path1 = Paths.get("dicionario.csv");

            try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("UTF-8"))) {// Charset.defaultCharset())

                String line = reader.readLine();
                while (line != null) {
                    aux = line.split(";");
                    Palavra p = new Palavra(aux[0], aux[1]);
                    lista.add(p);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                System.err.format("Erro na leitura do arquivo: ", e);
            }

            for (Palavra palavra : lista) {
                arvore.addWord(palavra.getPalavra(), palavra.getSignificado());
            }
            System.out.println("----TRABALHO DE ALEST----");
            System.out.println("Escreva um prefixo para buscar");
            String pesquisa = input.nextLine();
            System.out.print("\n");

            while (!pesquisa.matches("[a-zA-Z]+")) {
                System.out.println("Prefixo inválido. Por favor, digite um prefixo válido:");
                pesquisa = input.nextLine();
                System.out.print("\n");
            }

            listaPesquisa = arvore.searchAll(pesquisa);
            if (listaPesquisa.isEmpty()) {
                System.out.println("Não existem palavras com este prefixo no dicionário.");
                System.exit(0);
            }

            for (int i = 0; i < listaPesquisa.size(); i++) {
                System.out.println(i + 1 + ": " + listaPesquisa.get(i));

            }
            System.out.print("\n");

            int escolha = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.println("Digite o numero da palavra que deseja ver o significado:");
                String userInput = input.nextLine();

                try {
                    escolha = Integer.parseInt(userInput);
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número válido.");
                }
            }

            System.out.println("Você escolheu: " + escolha);

            for (int j = 0; j < lista.size(); j++) {
                if ((lista.get(j).getPalavra()).equals(listaPesquisa.get(escolha - 1))) {
                    String primeiraLetraMaiuscula = lista.get(j).getSignificado().substring(0, 1).toUpperCase()
                            + lista.get(j).getSignificado().substring(1).toLowerCase();

                    System.out.println((lista.get(j).getPalavra()) + ": " + primeiraLetraMaiuscula);
                }
            }
        }

        System.out.print("\n");

    }

}