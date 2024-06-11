import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author flash
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tree<String> treeB = new Tree<>("B");
        Tree<String> treeA = new Tree<>("A");
        Tree<String> treeD = new Tree<>("D");
        Tree<String> treeC = new Tree<>("C");
        Tree<String> treeE = new Tree<>("E");
        Tree<String> treeF = new Tree<>("F");
        Tree<String> treeG = new Tree<>("G");
        treeB.addChild(treeA);
        treeB.addChild(treeD);
        treeB.addChild(treeF);
        treeD.addChild(treeC);
        treeD.addChild(treeE);
        treeE.addChild(treeG);

        System.out.println("Total de filhos de B: " + treeB.childrenCount());
        for (int f = 0; f < treeB.childrenCount(); f++)
            System.out.println(treeB.getChild(f).item);        
        System.out.println();

        System.out.println("Pré-ordem:");
        List<Tree<String>> preordem = treeB.preOrder();
        for (Tree<String> no : preordem)
            System.out.println("-> " + no.item);

        System.out.println("Pós-ordem:");
        List<Tree<String>> posOrdem = treeB.postOrder();
        for (Tree<String> no : posOrdem)
            System.out.println("-> " + no.item);
        
        System.out.println();
        System.out.println("Número de nós: "+treeB.size());

        System.out.println();
        System.out.println("Nível do B: "+treeB.level());
        System.out.println("Nível do C: "+treeC.level());
        System.out.println("Nível do F: "+treeF.level());

        System.out.println();
        System.out.println("Altura da árvore: "+treeB.height());
    }
}
