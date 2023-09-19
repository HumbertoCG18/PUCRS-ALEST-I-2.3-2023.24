package Aula_24_08_2023;
import java.util.Random;

/**
 * Principal
 */
public class Principal {

    public static void main(String[] args) {
        Pilha p = new Pilha();
        System.out.println("Inserindo valores na pilha");
        Random r = new Random();
        for(int i=0; i< 12; i++){
            int valor = r.nextInt(100);
            p.push(valor);
            try {
                System.out.println("nElementos:"+p.size()+"; Valor inserido: " + 
                                    valor + 
                                    "; topo da pilha: " + 
                                    p.top());    
            } catch (Exception e) {
                System.out.println("Exceção gerada");
            }
        }

        for(int i=0; i< 12; i++){
            try {
                int valor=p.pop();
                System.out.println("Agora a pilha tem "+p.size()+ " elementos; valor removido: "+valor);
            } catch (Exception e) {
                System.out.println("Exceção gerada.. a pilha deve estar vazia");
                System.out.println(e.getMessage());
            }
            
        }

            
    }
}