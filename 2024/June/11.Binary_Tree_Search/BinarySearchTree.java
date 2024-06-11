import java.util.List;
import java.util.LinkedList;

public class BinarySearchTree<E extends Comparable<E>>
{

    private static final class Node<E> {

        public Node<E> parent;
        public Node<E> left;
        public Node<E> right;
        public E element;

        public Node(E element) {
            parent = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    // Atributos        
    private int count; //contagem do número de nodos
    private Node<E> root; //referência para o nodo raiz

    public BinarySearchTree() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return count;
    }

    public E getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public void add(E element) {
        Node<E> aux = new Node<E>(element);
        if (root == null) { // Se for o primeiro elemento, cria como raiz e retorna
            root = aux;
            return;
        }
        // Completar
    }

    public boolean contains(E element)
    {
        Node<E> atual = root;
        // Completar
        return false;
    }

    public List<E> positionsCentral() {
        List<E> res = new LinkedList<>();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Node<E> n, List<E> res) {
        if (n != null) {
            positionsCentralAux(n.left, res); //Visita a subárvore da esquerda
            res.add(n.element); //Visita o nodo
            positionsCentralAux(n.right, res); //Visita a subárvore da direita
        }
    }

    private void geraConexoesDOT(StringBuilder sb, Node<E> nodo) {
        if (nodo == null) {
            return;
        }

        geraConexoesDOT(sb, nodo.left);
        //   "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            sb.append("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" \n");
        }

        geraConexoesDOT(sb, nodo.right);
        //   "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            sb.append("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" \n");
        }
        //"[label = " << nodo->hDir << "]" <<endl;
    }

    private void geraNodosDOT(StringBuilder sb, Node<E> nodo) {
        if (nodo == null) {
            return;
        }
        geraNodosDOT(sb,nodo.left);
        //node10[label = "<esq> | 10 | <dir> "];
        sb.append("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]\n");
        geraNodosDOT(sb,nodo.right);
    }

    public void geraConexoesDOT(StringBuilder sb) {
        geraConexoesDOT(sb, root);
    }

    public void geraNodosDOT(StringBuilder sb) {
        geraNodosDOT(sb,root);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline 
    public String toDOT() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph g { \nnode [shape = record,height=.1];\n");
        geraNodosDOT(sb);
        geraConexoesDOT(sb);
        sb.append("}\n");
        return sb.toString();
    }    
}
