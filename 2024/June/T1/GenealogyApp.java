package June.T1;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GenealogyApp {
    public static void main(String[] args) {
        GenealogyTree arvore = readTree("2024\\June\\T1\\Arvore.txt");

        try (FileWriter writer = new FileWriter("2024\\June\\T1\\Saida.txt", StandardCharsets.UTF_8)) {

            writer.write("2. Ascendentes de Júlia S01 A02:\n");
            List<String> asc = arvore.ascendentes("Júlia S01 A02");
            for (String s : asc) {
                writer.write(s + "  ");
            }
            writer.write("\n---\n");

            writer.write("\n3. Número de descendentes de Mauro Paulo S01: " +
                    arvore.contarDescendentes("Mauro Paulo S01"));
            writer.write("\n---\n");

            writer.write("\n4. Filhos de Mauro Paulo S01: ");
            List<String> filhos = arvore.listarFilhos("Mauro Paulo S01");
            for (String s : filhos) {
                writer.write(s + "  ");
            }
            writer.write("\n---\n");

            writer.write("\n5. Netos de Edmundo Antônio S01:\n");
            List<String> netos = arvore.netos("Edmundo Antônio S01");
            for (String s : netos) {
                writer.write(s + "  ");
            }
            writer.write("\n---\n");

            writer.write("\n6. Tios de Júlia S01 A02:\n");
            List<String> tios = arvore.tios("Júlia S01 A02");
            for (String s : tios) {
                writer.write(s + "  ");
            }
            writer.write("\n---\n");

            writer.write("\n7. Primos de Júlia S01 A02:\n");
            List<String> primos = arvore.primos("Júlia S01 A02");
            for (String s : primos) {
                writer.write(s + "  ");
            }
            writer.write("\n---\n");

            writer.write("\n8. Mostrar estrutura hierárquica a partir de AA:\n");
            writer.write(arvore.mostrarParaArquivo("AA"));
            writer.write("\n---\n");

            writer.write("\nMostrar estrutura hierárquica a partir de Henrique João S01:\n");
            writer.write(arvore.mostrarParaArquivo("Henrique João S01"));
            writer.write("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
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
