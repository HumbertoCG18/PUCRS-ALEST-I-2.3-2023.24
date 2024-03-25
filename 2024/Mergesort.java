import java.util.Random;

public class Mergesort {
    private int[] data;
    private int[] arr;

    private int number;

    public void sort(int[] values) {
        this.data = values;
        number = values.length;
        this.arr = new int[number];
        mergesort(0, number - 1);
    }

    private void mergesort(int start, int end) {
        // Verifica se start é menor que end, caso contrário terminou
        if (start < end) {
            // Obtém o índice o elemento no meio
            int mid = (start + end) / 2;
            // Ordena o lado esquerdo
            mergesort(start, mid);
            // Ordena o lado direito
            mergesort(mid + 1, end);
            // Combina ambos
            merge(start, mid, end);
        }
    }

    private void merge(int start, int mid, int end) {
        int p = start, q = mid+1;
        int k=0;
        for(int i=start; i<= end; i++) {
            if(p > mid)
                arr[k++] = data[q++];
            else if(q > end)
                arr[k++] = data[p++];
            else if(data[p] < data[q])
                arr[k++] = data[p++];
            else
                arr[k++] = data[q++];
        }
        for(p=0; p<k; p++)
            data[start++] = arr[p];
    }

    public static void main(String args[]) {
        Random r = new Random();
        int MAX = 10000;
        int[] data = new int[MAX];
        for(int i=0; i<data.length; i++)
            data[i] = r.nextInt(data.length*10);

        long start = System.nanoTime();
        Mergesort ms = new Mergesort();
        ms.sort(data);
        long end = System.nanoTime();
        for(int i=0; i<data.length; i++)
            System.out.print(data[i]+" ");
        System.out.println();
        System.out.printf("Tempo para ordenar %d elementos: %d ns\n",MAX,end-start);
    }
}
