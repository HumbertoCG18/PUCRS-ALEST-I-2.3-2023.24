package April.ListArray;
//import java.util.Random;


public class App {
    public static void main(String[] args) {
        ListArray lista = new ListArray();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        
        System.out.println(lista);
       
        System.out.println("Elemento armazenado na "
                + "primeira posicao da lista: " +lista.get(0));

    }
}
