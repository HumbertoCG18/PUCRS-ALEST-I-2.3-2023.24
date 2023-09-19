package Aula_15_08_2023;
/**
 * Segundo
 */
public class Segundo {

    public static void main(String[] args) {

        int tamVet = Integer.parseInt(args[0]);

        int vetor[] = new int[tamVet];
        for(int i=0; i<tamVet; i++)
            vetor[i]=i+1;

        for(int i=0; i<vetor.length; i++)
            System.out.printf("[%d]: %d\n", i, vetor[i]);

        inverteVetor(vetor, 0);

        for(int i=0; i<vetor.length; i++)
            System.out.printf("[%d]: %d\n", i, vetor[i]);

        
    }

    private static void inverteVetor(int [] vet, int posAtual){

        if(posAtual>=(vet.length/2))
            return;
        else{
            int aux=vet[posAtual];
            vet[posAtual]=vet[vet.length-1-posAtual];
            vet[vet.length-1-posAtual]=aux;
            inverteVetor(vet, posAtual+1);
        }
    }
}