package April;
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

        System.out.println("Elemento armazenado na primeira posicao da lista: " + lista.get(0));

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

        // Testando o método unique
        System.out.println();
        System.out.println("Testando o método unique");
        ListArray lista3 = new ListArray();
        lista3.add(1);
        lista3.add(1);
        lista3.add(2);
        lista3.add(3);
        lista3.add(3);
        lista3.add(4);
        lista3.add(4);
        lista3.add(5);
        lista3.add(5);
        lista3.unique();
        System.out.println(lista3);

        // Testando o método mergeOrderedLists
        System.out.println();
        System.out.println("Testando o método mergeOrderedLists");
        ListArray lista4 = mergeOrderedLists(lista, lista2);
        System.out.println(lista4);
    }

    public static ListArray mergeOrderedLists(ListArray list1, ListArray list2) {
        ListArray mergedList = new ListArray();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            int element1 = list1.get(i);
            int element2 = list2.get(j);

            if (element1 < element2) {
                mergedList.add(element1);
                i++;
            } else if (element1 > element2) {
                mergedList.add(element2);
                j++;
            } else { // Se os elementos forem iguais, adicionamos apenas um deles e avançamos em ambas as listas
                mergedList.add(element1);
                i++;
                j++;
            }
        }

        // Adiciona os elementos restantes da primeira lista, se houver
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        // Adiciona os elementos restantes da segunda lista, se houver
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }
}