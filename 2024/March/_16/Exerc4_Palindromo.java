package March._16;
public class Exerc4_Palindromo {

    public static boolean palindromo(String str)
    {
        return palindromoRec(str, 0);
    }

    public static boolean palindromoRec(String str, int pos)
    {
        if(pos == str.length()/2)
            return true;
        if(str.charAt(pos) != str.charAt(str.length()-pos-1))
            return false;
        return palindromoRec(str, pos+1);
    }

    public static void main(String[] args) {

        String s = "ABCCBA";
        System.out.println(s+" é palíndromo: "+palindromo(s));
    }
}
