
public class App {
    public static void main(String[] args) {
        ListArray lista = new ListArray();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);

        lista.add(0, 1);

        System.out.println(lista);

        System.out.println("Elemento armazenado na "
                + "primeira posicao da lista: " + lista.get(0));

                
        System.out.println("Posição do 8: " + lista.indexOf(8));
        System.out.println("Posição do 18: " + lista.indexOf(18));

        // Tentando remover o número 6
        boolean ok = lista.remove(6);
        System.out.println();
        if (ok)
            System.out.println("OK! Consegui remover!");
        else
            System.out.println("Elemento não existe");
        System.out.println(lista);

        // Invertendo a lista
        System.out.println();
        lista.reverse();
        System.out.println(lista);
 
        // Inserindo em ordem crescente
        System.out.println();
        System.out.println("Testando inserção em ordem crescente");
        ListArray lista2 = new ListArray();
        for (int i = 1; i < 20; i += 4)
            lista2.addIncreasingOrder(i);
        System.out.println();
        System.out.println(lista2);
        lista2.addIncreasingOrder(0);
        lista2.addIncreasingOrder(30);
        lista2.addIncreasingOrder(11);
        System.out.println(lista2);

        // acrescente código para testar cada um dos novos 
        // métodos implementados, exceto o exercício HighScores 
        // que tem uma classe de teste específica
        
    }

}
