package Aula_19_09_2023;

/**
public class ListaDuplamenteEncadeada {

    private class Nodo{
        public int value;
        public Nodo prox;
        public Nodo prev;
        public Nodo(int v){
            value=v;
            prox=null;
            prev=null;
        }
    }

    private Nodo header, tail;
    private int nElements;

    public ListaDuplamenteEncadeada() {
        header=null;
        tail=null;
        nElements=0;
    }

    public boolean add(int value){
        Nodo aux = new Nodo(value);

        if(nElements==0){ // if(header==null) -> se for o primeiro elemento da lista
            header=aux;
        }
        else{
            tail.prox=aux;
            aux.prev=tail;
        }

        tail=aux;
        nElements++;
        return true;
    }

    public boolean add(int value, int index){
        if((index<0)||(index>=nElements))
            throw new ArrayIndexOutOfBoundsException("Indice informado não é válido");

        Nodo nav = header;
        while(index>0){
            nav=nav.prox;
            index--;
        }
        Nodo aux = new Nodo(value);

        if(nav==header){
            header.prev=aux;
            aux.prox=header;
            header=aux;
        }
        else{

            aux.prox=nav;
            aux.prev=nav.prev;

            aux.prev.prox=aux;
            aux.prox.prev=aux;
        }

        nElements++;
        return true;        
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

}
 */