package Aula_12_09_2023.listaEstatica;

/**
 * ListaEstatica
 */
public class ListaEstatica {

    int base[];
    int nElements;

    public ListaEstatica() {
        base = new int[4];
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
        System.out.println("Vetor incrementado");
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
        if( (index >=0) && (index<nElements) )
            return base[index];
        throw new ArrayIndexOutOfBoundsException("Indice inválido: "+index);
    }
    
    public void remove(int index){
        if( (index<0) || (index>=nElements) )
            throw new ArrayIndexOutOfBoundsException("Indice inválido: "+index);
        
        for(int i=index; i<nElements-1; i++)
            base[i]=base[i+1];

        nElements--;

    }
    
    public int set(int value, int index){
        if( (index<0) || (index>=nElements) )
            throw new ArrayIndexOutOfBoundsException("Indice inválido: "+index);
        
        int aux=base[index];
        base[index]=value;
        return aux;
    }
    
    public void clear(){
        nElements=0;
    }

    public boolean contains(int value){
        for(int i=0; i<nElements; i++)
            if(base[i]==value)
              return true;
        return false;
    }
    
    public int indexOf(int value){
        for(int i=0; i<nElements; i++)
            if(base[i]==value)
              return i;
        return -1;
    }
    
    public boolean isEmpty(){
        return (nElements==0);
    }
    
    public int lastIndexOf(int value){
        for(int i=nElements-1; i>=0; i--)
            if(base[i]==value)
              return i;
        return -1;
    }
    
    public int size(){
        return nElements;
    }

}