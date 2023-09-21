package Aula_12_09_2023.ListaDinamicaSimples;

import Aula_12_09_2023.listaEstatica.ListaEstatica;

public class Main {

    public static void main(String[] args) {
        ListaEstatica le = new ListaEstatica();

        le.add(3);
        le.add(5);
        le.add(7);
        le.add(9);
        le.add(10);

        for(int i=0; i<le.size(); i++)
            System.out.println("le["+i+"]: "+le.get(i));


        le.add(11, 2);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        for(int i=0; i<le.size(); i++)
            System.out.println("le["+i+"]: "+le.get(i));
        
        le.remove(3);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        for(int i=0; i<le.size(); i++)
            System.out.println("le["+i+"]: "+le.get(i));

        /*le.remove(13); Não é possivel ele acessar um index que a lista não possui.
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        for(int i=0; i<le.size(); i++)
            System.out.println("le["+i+"]: "+le.get(i));
        */

        le.add(10);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        for(int i=0; i<le.size(); i++)
            System.out.println("le["+i+"]: "+le.get(i));
        System.out.println("contains 10: "+le.contains(10));
        System.out.println("indexOf10: "+le.indexOf(10));
        System.out.println("lastIndexOf10: "+le.lastIndexOf(10));

                        
                        

    }
    
}
