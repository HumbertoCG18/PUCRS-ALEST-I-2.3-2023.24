import java.util.List;

public class App {
	public static void main(String[] args) {
		// T={A,{B,0,0},{C,0,{D,0,0}}}
		BinaryTree<String> ta = new BinaryTree<String>("A");
		BinaryTree<String> tb = new BinaryTree<String>("B");
		ta.addLeft(tb);
		BinaryTree<String> tc = new BinaryTree<String>("C");
		ta.addRight(tc);
		BinaryTree<String> td = new BinaryTree<String>("D");
		tc.addRight(td);

        /*
		System.out.println("Numero de nos: " + ta.size());

        List<String> lista = ta.traversalPre();
        System.out.println("Percurso pre-ordem: "+lista);

        lista = ta.traversalPos();
        System.out.println("Percurso pos-ordem: "+lista);
        
        lista = ta.traversalBreadth();
        System.out.println("Percurso em largura: "+lista);
        */
	}
}
