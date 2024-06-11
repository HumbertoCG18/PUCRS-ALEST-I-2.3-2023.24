import java.util.ArrayList;
import java.util.List;

public class Tree<E> {

    public Tree<E> parent;
    public E item;
    private List<Tree<E>> children;

    public Tree(E item) {
        this.parent = null;
        this.item = item;
        children = new ArrayList<Tree<E>>();
    }

    public void addChild(Tree<E> tree) {
        children.add(tree);
        tree.parent = this;
    }

    public void addChild(int index, Tree<E> tree) {
        children.add(index, tree);
        tree.parent = this;
    }

    public Tree<E> removeChild(int index) {
        Tree<E> child = children.remove(index);
        child.parent = null;
        return child;
    }

    public Tree<E> getChild(int index) {
        return children.get(index);
    }

    public int childrenCount() {
        return children.size();
    }

    public int size() {
        return sizeRecursive(this);
    }

    private int sizeRecursive(Tree<E> atual) {
        System.out.println("Estou em "+atual.item);
        int total = 1; // raiz + filhos
        for (Tree<E> filho : atual.children) {
            total += sizeRecursive(filho);
        }
        System.out.println(atual.item+ " vai retornar: "+total);
        return total;
    }

    public int level() {
        int lev = 0;
        Tree<E> atual = this;
        // Enquanto não chegar à raiz
        while(atual.parent != null) {
            lev++;
            atual = atual.parent;
        }
        return lev;
    }

    public int height() {
        return heightRecursive(this);
    }

    private int heightRecursive(Tree<E> atual) {
        int maior = 0;
        if(atual.childrenCount() == 0)
            return atual.level();
        for (Tree<E> filho : atual.children) {
            int alt = heightRecursive(filho);
            if(alt > maior) maior = alt;            
        }
        return maior;
    }

    public List<Tree<E>> preOrder() {
        List<Tree<E>> result = new ArrayList<>();
        preOrderRecursive(this, result);
        return result;
    }

    private void preOrderRecursive(Tree<E> atual, List<Tree<E>> lista) {
        lista.add(atual);
        for (Tree<E> filho : atual.children)
            preOrderRecursive(filho, lista);
    }

    public List<Tree<E>> postOrder() {
        List<Tree<E>> result = new ArrayList<>();
        postOrderRecursive(this, result);
        return result;
    }

    private void postOrderRecursive(Tree<E> atual, List<Tree<E>> lista) {
        for (Tree<E> filho : atual.children)
            postOrderRecursive(filho, lista);
        lista.add(atual);
    }
}
