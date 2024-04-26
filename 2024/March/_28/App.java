import java.util.Arrays;
import java.util.Random;

public class App
{
    public static void main(String[] args) {
        Random r = new Random();
        for(int n=10; n<10000; n++) {
            int[] vet = new int[n];
            for(int i=0; i<n; i++)
                vet[i] = r.nextInt(n*10);
            // Faz alguma coisa com o vetor
            int op = 0;
            System.out.println(n+" "+op);
        }
    }
}
