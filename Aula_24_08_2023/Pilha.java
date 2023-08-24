package Aula_24_08_2023;

public class Pilha {

        private int pilhaInterna[];
        private final int max = 10; 
        private int topo; 

        public Pilha(){
        pilhaInterna = new int[max];
        topo = 0; 
        }

    public void push (int e){

        if(topo<max){
            pilhaInterna[topo]=e;
            topo++;
        }
    }

    public int pop() throws Exception{
        if(topo>0){
            int aux=pilhaInterna[topo-1];
            topo--;
            return aux;
        }
        System.out.println("A pilha está vazia.");
        throw new Exception("A pilha está vazia"); 
    }

    public int top () throws Exception{
        if(topo>0){
           return pilhaInterna[topo-1];
        }
        System.out.println("A pilha está vazia.");
        throw new Exception("A pilha está vazia"); 
    }

    public int size(){
        return topo;
    }

    public boolean isEmpty(){
        // return (topo==0);
        if(topo==0){
            return true;
        } else {
            return false;
        }
    }

    public void clear(){
        topo=0;
    }
}
