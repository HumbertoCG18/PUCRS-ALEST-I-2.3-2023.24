package Aula_15_08_2023;

public class NonRecursiva{

    public static double calcularPotencia(double base, int expoente) {
        double resultado = 1.0;
        
        for (int i = 0; i < expoente; i++) {
            resultado *= base;
        }
        
        return resultado;
    }

    public static void main(String[] args) {
        double base = 2.0;
        int expoente = 5;
        
        double resultado = calcularPotencia(base, expoente);
        System.out.println(base + " elevado a " + expoente + " é igual a " + resultado);
    }
}