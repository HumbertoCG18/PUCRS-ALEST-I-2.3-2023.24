package Aula_05_09_2023;

/**
 * ListaEstatica
 */
public class ListaEstatica {

    int base[];
    int nElements;

    public ListaEstatica() {
        base = new int[10];
        nElements = 0;
    }

    public boolean add(int value){
        if(nElements>=base.length)
            grow();
        base[nElements]=value;
        nElements++;
        return true;
    }

    private void grow(){
        int aux [] = new int [base.length*2];
        for(int i=0; i<base.length; i++)
            aux[i]=base[i];
        base=aux;
    }

    public boolean add(int value, int index){
        if( (index >=0) && (index<=nElements) ){
            if(nElements>=base.length)
                grow();
            for(int i=nElements; i>index; i--)
                base[i]=base[i-1];
            base[index]=value;
            nElements++;
            return true;
        }        
        return false;
    }
    
    public int get(int index){
        return -1;
    }
    
    public void remove(int index){
    }
    
    public int set(int value, int index){
        return -1;
    }
    
    public void clear(){
    }

    public boolean contains(int value){
        return false;
    }
    
    public int indexOf(int value){
        return -1;
    }
    
    public boolean isEmpty(){
        return false;
    }
    
    public int lastIndexOf(int value){
        return -1;
    }
    
    public int size(){
        return 0;
    }

}