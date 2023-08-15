package Aula_15082023;

public class Recursiva{

    public static double calcularPotencia(double base, int expoente) {
        if (expoente == 0) {
            return 1.0;
        } else {
            return base * calcularPotencia(base, expoente - 1);
        }
    }

    public static void main(String[] args) {
        double base = 2.0;
        int expoente = 5;
        
        double resultado = calcularPotencia(base, expoente);
        System.out.println(base + " elevado a " + expoente + " é igual a " + resultado);
    }
}
