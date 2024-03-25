package Aula_29_08_2023;
/**
 * Fila
 */
public class Fila {

    int base [];
    int nroElementos;

    public Fila(int capacidade) {
        base = new int[capacidade];
        nroElementos=0;        
    }

    public boolean enfileira(int valor){
        if(nroElementos<base.length){
            base[nroElementos]=valor;
            nroElementos++;
        }
        return false;
    }

    public int desenfileira() throws Exception{
        if(nroElementos==0)
          throw new Exception("A fila está vazia");

        int aux = base[0];
        //ajustar a fila
        for(int i=0; i<nroElementos-1; i++)
          base[i]=base[i+1];
        nroElementos--;
        return aux;
    }

    public int primeiroElemento() throws Exception{
        if(nroElementos==0)
          throw new Exception("A fila está vazia");

        int aux = base[0];
        return aux;
    }

    public int quantidadeDeElementos(){
        return nroElementos;
    }

    public int capacidade(){
        return base.length;
    }

    public boolean estaVazio(){
        return (nroElementos==0);
    }
    
    public void esvaziar(){
        nroElementos=0;
    }

    
}