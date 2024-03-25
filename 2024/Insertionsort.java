import java.util.Random;

public class Insertionsort
{
    private int[] data;

    public Insertionsort(int[] data) {
        this.data = data;
    }

    public void sort() {
        int temp, j;
        int n = data.length;
        for(int i=0; i<n; i++) {
            temp = data[i];
            j = i;
            while(j>0 && temp < data[j-1]) {
                data[j] = data[j-1];
                j--;
                data[j] = temp;
            }
        }
    }

    public static void main(String args[]) {
        Random r = new Random();
        int MAX = 10000;
        int[] data = new int[MAX];
        for(int i=0; i<data.length; i++)
            data[i] = r.nextInt(data.length*10);

        Insertionsort is = new Insertionsort(data);
        long start = System.nanoTime();
        is.sort();
        long end = System.nanoTime();
        for(int i=0; i<data.length; i++)
            System.out.print(data[i]+" ");
        System.out.println();
        System.out.printf("Tempo para ordenar %d elementos: %d ns\n",MAX,end-start);
    }
}

