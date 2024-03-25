package Aula_14_09_2023;
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

    private Nodo header, tail;
    private int nElements;

    public ListaDinamicaSimples() {
        header=null;
        tail=null;
        nElements=0;
    }

    public boolean add(int value){
        Nodo aux = new Nodo(value);

        if(header==null)
            header=aux;
        else
            tail.prox=aux;
        tail=aux;

        nElements++;

        return true;
    }

    public boolean add(int value, int index){
        if((index<0) || (index>=nElements))
          return false;

        Nodo aux = new Nodo(value);
        if(index==0){
            aux.prox=header;
            header=aux;
        }
        else{
            Nodo navegador=header;
            while(index>1){
                navegador=navegador.prox;
                index--;
            }
            aux.prox=navegador.prox;
            navegador.prox=aux;
        }
        nElements++;

        return true;
    }
    
    public int get(int index){
        if((index<0) || (index>=nElements))
          throw new ArrayIndexOutOfBoundsException();

        Nodo aux;
        if(index==0)
            aux=header;
        else if(index==nElements-1)
            aux=tail;
        else{
            int pos=0;
            aux=header;
            while(pos!=index){
                aux=aux.prox;
                pos++;
            }
        }

        return aux.value;

    }
    
    public void remove(int index){
        if((index<0) || (index>=nElements))
          throw new ArrayIndexOutOfBoundsException();

        Nodo aux;
        if(index==0){
            aux=header;
            header=aux.prox;
            aux.prox=null;
        }
        else{
            aux=header;
            while(index>1){
                aux=aux.prox;
                index--;
            }
            Nodo tmp=aux.prox;
            aux.prox=tmp.prox;

            if(aux.prox==null)
                tail=aux;

            tmp.prox=null;

        }

        nElements--;
    }
    
    public int set(int value, int index){
        if((index<0) || (index>=nElements))
          throw new ArrayIndexOutOfBoundsException();

        Nodo aux=header;
        while(index>0){
            aux=aux.prox;
            index--;
        }
        int tmp=aux.value;
        aux.value=value;
        return tmp;
    }
    
    public void clear(){
        nElements=0;
        header=null;
        tail=null;
    }

    public boolean contains(int value){
        Nodo aux=header;
        while(aux!=null){
            if(aux.value==value)
                return true;
            aux=aux.prox;
        }
        return false;
    }
    
    public int indexOf(int value){
        Nodo aux=header;
        int pos=0;
        while(aux!=null){
            if(aux.value==value)
                return pos;
            aux=aux.prox;
            pos++;
        }
        return -1;
    }
    
    public boolean isEmpty(){
        return (nElements==0);
    }
    
    public int lastIndexOf(int value){
        Nodo aux=header;
        int pos=0;
        int idx=-1;
        while(aux!=null){
            if(aux.value==value)
                idx=pos;
            aux=aux.prox;
            pos++;
        }
        return idx;
    }
    
    public int size(){
        return nElements;
    }

}