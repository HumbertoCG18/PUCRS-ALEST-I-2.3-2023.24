package Aula_29_08_2023;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Fila minhaFila = new Fila(5);        
        minhaFila.enfileira(4);
        minhaFila.enfileira(7);
        minhaFila.enfileira(14);
        minhaFila.enfileira(41);
        minhaFila.enfileira(43);
        minhaFila.enfileira(541);

        try {
            System.out.println("conteudo da fila");
            while(minhaFila.quantidadeDeElementos()>0)
              System.out.println("  valor: "+minhaFila.desenfileira());
        } catch (Exception e) {
            System.out.println("Erro na manipulação da fila");
        }

    }
}
