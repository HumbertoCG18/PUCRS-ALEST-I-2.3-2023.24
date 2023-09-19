package Aula_12_09_2023.ListaDinamicaSimples;
/**
 * ListaDinamicaSimples
 */
public class ListaDinamicaSimples {

    private class Nodo{
        public int value;
        public Nodo prox;
        public Nodo(int v){
            value=v;
            prox=null;
        }
    }

    private Nodo header;
    private int nElements;


    public ListaDinamicaSimples() {
        header=null;
        nElements=0;
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

    /**public boolean add(int value, int index){
    }
    
    public int get(int index){
    }
    
    public void remove(int index){
    }
    
    public int set(int value, int index){
    }
    
    public void clear(){
    }

    public boolean contains(int value){
    }
    
    public int indexOf(int value){
    }
    
    public boolean isEmpty(){
    }
    
    public int lastIndexOf(int value){
    }
    
    public int size(){
    }
/** */
}
