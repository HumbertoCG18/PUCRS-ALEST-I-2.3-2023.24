public class Main{

  public static void main(String args[]){

    for(int n=10; n<10000; n+=100)
      System.out.println(n+";"+f2(n));
    
  }

  public static int f1(int n){
    int cont=0;
    for(int i=0; i<n; i++)
      cont++;
    return cont;
  }

  public static int f2(int n){
    int cont=0;
    for(int i=0; i<n; i++)
      for(int j=i; j<2*i; j++)
        cont++;
    return cont;
  }

}
