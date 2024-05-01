package March._16;
public class Exerc3_Soma {

    public static int soma(int[] v)
    {
        return somaRec(v, 0);
    }

    public static int somaRec(int[] v, int pos)
    {
        if(pos == v.length)
            return 0;
        return v[pos] + somaRec(v, pos+1);
    }

    public static void main(String[] args) {

        int vet[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        for (int i: vet)
            System.out.printf("%d ", i);
        System.out.println();
        System.out.println("Soma: "+soma(vet));

    }
}
