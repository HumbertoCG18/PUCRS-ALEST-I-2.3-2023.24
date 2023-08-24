package Aula_15_08_2023;

public class VerifyPolinomio {

    // Função recursiva para verificar se uma string é um palíndromo
    public static boolean isPalindrome(String str) {
        // Converte a string para minúsculas para ignorar diferenças de caixa
        str = str.toLowerCase();
        return isPalindromeHelper(str, 0, str.length() - 1);
    }

    // Função auxiliar recursiva para verificar palíndromo
    private static boolean isPalindromeHelper(String str, int start, int end) {
        if (start >= end) {
            return true; // Condição de parada: índices se cruzaram
        } 
        
        else if (str.charAt(start) != str.charAt(end)) {
            return false; // Caracteres não correspondem
        } 
        
        else{
            return isPalindromeHelper(str, start + 1, end - 1); // Chamada recursiva
        }
    }

    public static void main(String[] args) {
        String palavra = "reconocer";
        boolean resultado = isPalindrome(palavra);
        
        if (resultado) {
            System.out.println("A string é um palíndromo.");
        } 
        
        else{
            System.out.println("A string não é um palíndromo.");
        }
    }
}
