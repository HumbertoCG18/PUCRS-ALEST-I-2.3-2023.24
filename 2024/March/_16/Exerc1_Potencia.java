package March._16;

public class Exerc1_Potencia {

    public static int potencia(int x, int y) {
        int res = 1;
        for (int i = 0; i < y; i++)
            res = res * x;
        return res;
    }

    public static int potenciaRec(int x, int y) {
        if (y == 0)
            return 1;
        return x * potenciaRec(x, y - 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++)
            System.out.printf("2 na %d: %d\n", i, potencia(2, i));

    }
}