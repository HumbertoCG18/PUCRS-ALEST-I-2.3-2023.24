
public class BinaryTreeOfInteger {

    /**
     * Classe interna estática para representar um nó da árvore.
     */
    private static final class Node {
        public Node parent;
        public Node left;
        public Node right;
        public Integer element;

        /**
         * Construtor do nó.
         * @param element O valor inteiro a ser armazenado no nó.
         */
        public Node(Integer element) {
            parent = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    private int count; // Número de nós na árvore
    private Node root; // Raiz da árvore

    /**
     * Construtor da árvore.
     */
    public BinaryTreeOfInteger() {
        count = 0;
        root = null;
    }

    /**
     * Adiciona um elemento à árvore de forma ordenada (como uma Árvore Binária de Busca).
     * @param element O elemento a ser adicionado.
     */
    public void add(Integer element) {
        Node newNode = new Node(element);
        if (root == null) {
            root = newNode;
        } else {
            add(root, newNode);
        }
        count++;
    }

    private void add(Node parent, Node newNode) {
        // Se o novo elemento for menor, vai para a esquerda
        if (newNode.element.compareTo(parent.element) < 0) {
            if (parent.left == null) {
                parent.left = newNode;
                newNode.parent = parent;
            } else {
                add(parent.left, newNode);
            }
        // Se o novo elemento for maior ou igual, vai para a direita
        } else {
            if (parent.right == null) {
                parent.right = newNode;
                newNode.parent = parent;
            } else {
                add(parent.right, newNode);
            }
        }
    }

    // -------------------------------------------------------------------
    // --- MÉTODO DE CAMINHAMENTO CENTRAL RECURSIVO ---
    // -------------------------------------------------------------------

    /**
     * Método público que inicia o caminhamento central a partir da raiz.
     */
    public void inOrderTraversal() {
        System.out.println("Iniciando Caminhamento Central (In-Order):");
        inOrder(root);
        System.out.println("\nFim do caminhamento.");
    }

    /**
     * Método privado e recursivo que executa o caminhamento central.
     * @param node O nó atual a ser visitado.
     */
    private void inOrder(Node node) {
        // O caso base da recursão é quando o nó é nulo (chegou ao fim de um galho)
        if (node != null) {
            // 1. Visita recursivamente a subárvore esquerda
            inOrder(node.left);

            // 2. Processa o elemento do nó atual (imprime na tela)
            System.out.print(node.element + " ");

            // 3. Visita recursivamente a subárvore direita
            inOrder(node.right);
        }
    }
    // -------------------------------------------------------------------

    /**
     * Método principal para demonstrar a funcionalidade da árvore e do caminhamento.
     */
    public static void main(String[] args) {
        // Cria uma nova árvore binária
        BinaryTreeOfInteger tree = new BinaryTreeOfInteger();

        // Adiciona elementos à árvore
        // A ordem de inserção define a estrutura da árvore
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);
        tree.add(75);
        tree.add(100);
        tree.add(95);
        
        /*
         * A árvore resultante terá a seguinte estrutura:
         *
         *      50
         *   /      \
         * 30       70
         * / \      / \
         * 20 40  60  80
         *
         */

        // Executa e imprime o resultado do caminhamento central
        // A saída esperada é a sequência de números em ordem crescente
        tree.inOrderTraversal();
    }
}