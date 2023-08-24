package Aula_24_08_2023;

import java.util.Random;

public class Principal {
    
    public static void main(String[] args){
        Pilha p = new Pilha();
        System.out.println("Inserindo valores na pilha");
        Random r = new Random();
        for (int i=0; i< 12; i++){
            int valor = r.nextInt(100);
            p.push(valor);
            try{
                 System.out.println("Valor inserido" + valor + "topo da pilha" + p.top());
                 
            }catch (Exception e) {
                System.out.println("Execução Gerada");
                 
            }
        }
    
        for (int i=0; i<12; i++){
            System.out.println("Agora a pilha tem" + p.size() + "elementos:" + valor);
        }catch (Exception e) {
                System.out.println.(e.getMessage());
                 
    }
}
