package Aula_31_08_2023.Fila_Circular;

/**
 * Fila
 */
public class Fila {

    int base [];
    int prim,fim;

    public Fila(int capacidade) {
        base = new int[capacidade+1];
        prim=0;
        fim=0;
    }

    public boolean enfileira(int valor){
        int novofim=(fim+1)%base.length;
        if(novofim!=prim){
            base[fim]=valor;
            fim=novofim;
            return true;
        }
        return false;
    }

    public int desenfileira() throws Exception{
        if(fim==prim)
          throw new Exception("A fila está vazia");

        int aux = base[prim];
        //ajustar a fila
        prim++;
        if(prim==base.length)
            prim=0;
        return aux;
    }

    public int primeiroElemento() throws Exception{
        if(fim==prim)
          throw new Exception("A fila está vazia");

        return base[prim];
    }

    public int quantidadeDeElementos(){
        if(prim<=fim)
            return fim-prim;
        else
            return (fim+base.length)-prim;
    }

    public int capacidade(){
        return base.length-1;
    }

    public boolean estaVazio(){
        return (prim==fim);
    }
    
    public void esvaziar(){
        prim=0;
        fim=0;
    }
}