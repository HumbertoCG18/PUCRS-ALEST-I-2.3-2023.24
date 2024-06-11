
public class App {
    public static void main(String[] args) {
        BinarySearchTree<Integer> b  = new BinarySearchTree<>();
        b.add(15);
        b.add(23);
        b.add(9);
        b.add(11);
        b.add(2);
        b.add(20);
        b.add(38);

        System.out.println("Central:\n" + b.positionsCentral());
        
        //System.out.println("Contem 2? " + b.contains(2));
        //System.out.println("Contem 38? " + b.contains(38));
        //System.out.println("Contem 55? " + b.contains(55));
        //System.out.println("Contem 32? " + b.contains(32));

        System.out.println("-------------");
        System.out.println(b.toDOT());
        System.out.println("-------------");        
     }
   
}
