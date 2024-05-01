package March._16;
public class Exerc2_Inverte {

    public static void inverte(int[] v)
    {
        inverteRec(v, 0);
    }

    public static void inverteRec(int[] v, int pos)
    {
        if(pos == v.length/2)
            return;
        int temp = v[pos];
        v[pos] = v[v.length-pos-1];
        v[v.length-pos-1] = temp;
        inverteRec(v, pos+1);
    }

    public static void main(String[] args) {

        int vet[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        for (int i: vet)
            System.out.printf("%d ", i);
        System.out.println();
        inverte(vet);
        for (int i: vet)
            System.out.printf("%d ", i);
        System.out.println();

    }
}
