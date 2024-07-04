package July;

import java.util.List;
import java.util.LinkedList;

public class BinarySearchTree<E extends Comparable<E>> {

    private static final class Node<E> {
        @SuppressWarnings("unused")
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

    private int count; // contagem do número de nodos
    private Node<E> root; // referência para o nodo raiz

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
            count++;
            return;
        }
        addRecursive(root, aux);
    }

    private void addRecursive(Node<E> current, Node<E> aux) {
        if (aux.element.compareTo(current.element) < 0) {
            if (current.left == null) {
                current.left = aux;
                aux.parent = current;
                count++;
            } else {
                addRecursive(current.left, aux);
            }
        } else if (aux.element.compareTo(current.element) > 0) {
            if (current.right == null) {
                current.right = aux;
                aux.parent = current;
                count++;
            } else {
                addRecursive(current.right, aux);
            }
        }
    }

    public boolean contains(E element) {
        return containsRecursive(root, element);
    }

    private boolean containsRecursive(Node<E> current, E element) {
        if (current == null) {
            return false;
        }
        if (element.equals(current.element)) {
            return true;
        }
        return element.compareTo(current.element) < 0
                ? containsRecursive(current.left, element)
                : containsRecursive(current.right, element);
    }

    public List<E> positionsCentral() {
        List<E> res = new LinkedList<>();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Node<E> n, List<E> res) {
        if (n != null) {
            positionsCentralAux(n.left, res); // Visita a subárvore da esquerda
            res.add(n.element); // Visita o nodo
            positionsCentralAux(n.right, res); // Visita a subárvore da direita
        }
    }

    private void geraConexoesDOT(StringBuilder sb, Node<E> nodo) {
        if (nodo == null) {
            return;
        }

        geraConexoesDOT(sb, nodo.left);
        if (nodo.left != null) {
            sb.append("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" \n");
        }

        geraConexoesDOT(sb, nodo.right);
        if (nodo.right != null) {
            sb.append("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" \n");
        }
    }

    private void geraNodosDOT(StringBuilder sb, Node<E> nodo) {
        if (nodo == null) {
            return;
        }
        geraNodosDOT(sb, nodo.left);
        sb.append("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]\n");
        geraNodosDOT(sb, nodo.right);
    }

    public void geraConexoesDOT(StringBuilder sb) {
        geraConexoesDOT(sb, root);
    }

    public void geraNodosDOT(StringBuilder sb) {
        geraNodosDOT(sb, root);
    }

    public String toDOT() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph g { \nnode [shape = record,height=.1];\n");
        geraNodosDOT(sb);
        geraConexoesDOT(sb);
        sb.append("}\n");
        return sb.toString();
    }

    // Método para encontrar o ancestral comum mais próximo
    public Node<E> anestral(Node<E> root, E i, E j) {
        if (root == null) {
            return null;
        }
        if (root.element.compareTo(i) > 0 && root.element.compareTo(j) > 0) {
            return anestral(root.left, i, j);
        }
        if (root.element.compareTo(i) < 0 && root.element.compareTo(j) < 0) {
            return anestral(root.right, i, j);
        }
        return root;
    }

    public void caminho(Node<E> root, E val, List<E> path) {
        if (root == null) {
            return;
        }
        path.add(root.element);
        if (root.element.equals(val)) {
            return;
        }
        if (root.element.compareTo(val) > 0) {
            caminho(root.left, val, path);
        } else {
            caminho(root.right, val, path);
        }
    }

    public int maxsoma(Node<E> node) {
        if (node == null) {
            return 0;
        }
        int leftSum = maxsoma(node.left);
        int rightSum = maxsoma(node.right);
        return Math.max(leftSum, rightSum) + (Integer) node.element;
    }

    public boolean isABP(Node<E> node, E min, E max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.element.compareTo(min) <= 0) {
            return false;
        }
        if (max != null && node.element.compareTo(max) >= 0) {
            return false;
        }
        return isABP(node.left, min, node.element) && isABP(node.right, node.element, max);
    }

    // Chamadas públicas dos métodos
    public E anestral(E i, E j) {
        Node<E> anc = anestral(root, i, j);
        return anc == null ? null : anc.element;
    }

    public void caminho(E val) {
        List<E> path = new LinkedList<>();
        caminho(root, val, path);
        for (E e : path) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public int maxsoma() {
        return maxsoma(root);
    }

    public boolean isABP() {
        return isABP(root, null, null);
    }
}
