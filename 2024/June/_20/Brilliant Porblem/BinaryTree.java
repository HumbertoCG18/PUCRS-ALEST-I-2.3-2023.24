import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<E> {
    public BinaryTree<E> parent; // nó pai
    public E item; // valor armazenado
    public boolean toggled;
    public int height;
    public BinaryTree<E> left; // subárvore esquerda
    public BinaryTree<E> right; // subárvore direita

    public BinaryTree(E element) {
        parent = null;
        item = element;
        left = null;
        right = null;
        toggled = false;
    }

    public void addLeft(BinaryTree<E> tree) {
        left = tree;
        tree.parent = this;
    }

    public void addRight(BinaryTree<E> tree) {
        right = tree;
        tree.parent = this;
    }

    public BinaryTree<E> removeLeft() {
        BinaryTree<E> subtree = left;
        left = null;
        subtree.parent = null;
        return subtree;
    }

    public BinaryTree<E> removeRight() {
        BinaryTree<E> subtree = right;
        right = null;
        subtree.parent = null;
        return subtree;
    }

    public E traverse(BinaryTree<E> root) {
        while (true) {
            if (root.height == 0)
                return root.item;

            root.toggled = !root.toggled;
            if (root.toggled)
                root = root.left;
            else
                root = root.right;
        }
    }

    // Outros métodos

    public String toString() {
        return item.toString();
    }

    public int degree() {
        int d = left != null ? 1 : 0;
        d += right != null ? 1 : 0;
        return d;
    }

    public int size() {
        return size(this);
    }

    private int size(BinaryTree<E> atual) {
        // System.out.println("Estou em "+atual.item);
        int total = 1; // raiz + filhos
        if (atual.left != null)
            total += size(atual.left);
        if (atual.right != null)
            total += size(atual.right);
        // System.out.println(atual.item+ " vai retornar: "+total);
        return total;
    }

    public int level() {
        int lev = 0;
        BinaryTree<E> atual = this;
        // Enquanto não chegar à raiz
        while (atual.parent != null) {
            lev++;
            atual = atual.parent;
        }
        return lev;
    }

    public int height() {
        return height(this);
    }

    private int height(BinaryTree<E> atual) {
        int maior = 0;
        if (atual == null)
            return 0;
        if (atual.left == null && atual.right == null)
            return atual.level();
        int leftHeight = height(atual.left);
        int rightHeight = height(atual.right);
        maior = leftHeight;
        if (rightHeight > maior)
            maior = rightHeight;
        return maior;
    }

    public List<BinaryTree<E>> preOrder() {
        List<BinaryTree<E>> result = new ArrayList<>();
        preOrder(this, result);
        return result;
    }

    private void preOrder(BinaryTree<E> atual, List<BinaryTree<E>> lista) {
        if (atual == null)
            return;
        lista.add(atual);
        preOrder(atual.left, lista);
        preOrder(atual.right, lista);
    }

    public List<BinaryTree<E>> postOrder() {
        List<BinaryTree<E>> result = new ArrayList<>();
        postOrder(this, result);
        return result;
    }

    private void postOrder(BinaryTree<E> atual, List<BinaryTree<E>> lista) {
        if (atual == null)
            return;
        postOrder(atual.left, lista);
        postOrder(atual.right, lista);
        lista.add(atual);
    }

    public List<BinaryTree<E>> inOrder() {
        List<BinaryTree<E>> result = new ArrayList<>();
        inOrder(this, result);
        return result;
    }

    private void inOrder(BinaryTree<E> atual, List<BinaryTree<E>> lista) {
        if (atual == null)
            return;
        inOrder(atual.left, lista);
        lista.add(atual);
        inOrder(atual.right, lista);
    }

    public List<BinaryTree<E>> breadth() {
        List<BinaryTree<E>> result = new ArrayList<>();
        List<BinaryTree<E>> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            BinaryTree<E> atual = queue.remove(0);
            result.add(atual);
            if (atual.left != null)
                queue.add(atual.left);
            if (atual.right != null)
                queue.add(atual.right);
        }
        return result;
    }

    public boolean contains(E element) {
        return contains(this, element);
    }

    public boolean contains(BinaryTree<E> atual, E element) {
        if (atual.item.equals(element))
            return true;
        if (atual.left != null && contains(atual.left, element) == true)
            return true;
        if (atual.right != null && contains(atual.right, element) == true)
            return true;
        return false;
    }

    private void geraConexoesDOT(StringBuilder sb, BinaryTree<E> nodo) {
        if (nodo == null) {
            return;
        }

        geraConexoesDOT(sb, nodo.left);
        // "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            sb.append("\"node" + nodo.item + "\":esq -> \"node" + nodo.left.item + "\" \n");
        }

        geraConexoesDOT(sb, nodo.right);
        // "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            sb.append("\"node" + nodo.item + "\":dir -> \"node" + nodo.right.item + "\" \n");
        }
        // "[label = " << nodo->hDir << "]" <<endl;
    }

    private void geraNodosDOT(StringBuilder sb, BinaryTree<E> nodo) {
        if (nodo == null) {
            return;
        }
        geraNodosDOT(sb, nodo.left);
        // node10[label = "<esq> | 10 | <dir> "];
        sb.append("node" + nodo.item + "[label = \"<esq> | " + nodo.item + " | <dir> \"]\n");
        geraNodosDOT(sb, nodo.right);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline
    public String toDOT(BinaryTree<E> root) {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph g { \nnode [shape = record,height=.1];\n");
        geraNodosDOT(sb, root);
        geraConexoesDOT(sb, root);
        sb.append("}\n");
        return sb.toString();
    }
}
