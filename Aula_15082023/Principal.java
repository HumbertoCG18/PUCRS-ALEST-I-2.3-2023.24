package Aula_15082023;

public class Principal {

    private static int expoenteNormal(int b, int e){
        int resultado=1;
        for(int i=0; i<e; i++)
            resultado=resultado*b;
        return resultado;
    }

    private static int expoenteRecursivo(int b, int e){

        if(e==0)
            return 1;
        else
            return b * expoenteRecursivo(b, e-1);

    }
    public static void main(String [] args) {

        int base = Integer.parseInt(args[0]);
        int expoente = Integer.parseInt(args[1]);

        System.out.println("Os valores informados foram:");
        System.out.println("  Base: "+base);
        System.out.println("  Expoente: "+expoente);

        int resultado = expoenteRecursivo(base, expoente);
        System.out.println("O resultado de "+base+" elevado a "+expoente+" é "+resultado);
    }
    
}