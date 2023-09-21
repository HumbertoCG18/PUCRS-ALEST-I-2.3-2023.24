package Aula_12_09_2023.ListaDinamicaSimples;

public class ListaDinamicaSimples {

    private class Nodo{
        public Nodo prox;
        public Nodo(int v){
            prox=null;
        }
    }

    private Nodo header;
    public ListaDinamicaSimples() {
        header=null;
    }

    public boolean add(int value){
        Nodo aux = new Nodo(value);
        if(header==null)
            header=aux;
        else{
            Nodo ptr = header;
            while(ptr.prox!=null)
                ptr=ptr.prox;
        }


        return true;
    }

    public int size() {
        return 0;
    }

    public String get(int i) {
        return null;
    }

    public void remove(int i) {
    }

    public int contains(int i) {
         return 0;
    }

    public int indexOf(int i) {
        return 0;
    }

    public int lastIndexOf(int i) {
        return 0;
    }

    public void add(int i, int j) {
    }

}
