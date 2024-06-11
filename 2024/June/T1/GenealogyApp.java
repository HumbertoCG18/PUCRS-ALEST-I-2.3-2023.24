package June.T1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GenealogyApp {
    public static void main(String[] args) {
        GenealogyTree arvore = readTree("2024\\June\\T1\\ArvoreTeste_UTF8.txt"); // Altere aqui

        System.out.println("\n2. Ascendentes de Júlia S01 A02:");
        List<String> asc = arvore.ascendentes("Júlia S01 A02");
        for (String s : asc) {
            System.out.print(s + "  ");
        }
        System.out.println("\n---");

        System.out.println("\n3. Número de descendentes de Mauro Paulo S01: " +
                arvore.contarDescendentes("Mauro Paulo S01"));
        System.out.println("\n---");

        System.out.println("\n4. Filhos de Mauro Paulo S01: ");
        List<String> filhos = arvore.listarFilhos("Mauro Paulo S01");
        for (String s : filhos) {
            System.out.print(s + "  ");
        }
        System.out.println("\n---");

        System.out.println("\n5. Netos de Edmundo Antônio S01:");
        List<String> netos = arvore.netos("Edmundo Antônio S01");
        for (String s : netos) {
            System.out.print(s + "  ");
        }
        System.out.println("\n---");

        System.out.println("\n6. Tios de Júlia S01 A02:");
        List<String> tios = arvore.tios("Júlia S01 A02");
        for (String s : tios) {
            System.out.print(s + "  ");
        }
        System.out.println("\n---");

        System.out.println("\n7. Primos de Júlia S01 A02:");
        List<String> primos = arvore.primos("Júlia S01 A02");
        for (String s : primos) {
            System.out.print(s + "  ");
        }
        System.out.println("\n---");

        System.out.println("\n8. Mostrar estrutura hierárquica a partir de AA:");
        arvore.mostrar("AA");
        System.out.println("\n---");

        System.out.println("\nMostrar estrutura hierárquica a partir de Henrique João S01:");
        arvore.mostrar("Henrique João S01");
    }

    private static GenealogyTree readTree(String arq) {
        GenealogyTree arv = null;
        try {
            BufferedReader buff = new BufferedReader(new FileReader(arq, StandardCharsets.UTF_8));
            String line = null;
            try {
                line = buff.readLine();
                line = line.trim();
                arv = new GenealogyTree(line);
                line = buff.readLine();

                while (line != null) {
                    line = line.trim();
                    String[] pessoas = line.split(" \\| ");
                    for (int i = 1; i < pessoas.length; i++) {
                        arv.inserir(pessoas[i], pessoas[0]);
                    }
                    line = buff.readLine();
                }
            } finally {
                buff.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arv;
    }
}
