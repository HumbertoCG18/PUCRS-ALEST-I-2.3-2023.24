
public class QueueLinked implements QueueTAD {

    private Node header;
    private Node trailer;
    private int count;

    private class Node {
        public int item;
        public Node next;
        public Node prev;

        public Node(int element) {
            this.item = element;
            this.next = null;
        }
    }

    public QueueLinked() {
        clear();
    }

    @Override
    public void enqueue(int element) {
        Node n = new Node(element);
        Node last = trailer.prev;
        n.prev = last;
        n.next = trailer;
        last.next = n;
        trailer.prev = n;
        count++;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        header = new Node(0);
        trailer = new Node(0);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Retorna o conteúdo da lista como uma string
     * 
     * @return uma string com os elementos da lista
     */
    @Override
    public String toString() {

        String aux = "[ ";
        // Começa no header.next (primeiro elem)
        Node ptr = header.next;
        // Se chegar no trailer, termina
        while (ptr != trailer) {
            aux = aux + ptr.item + " ";
            ptr = ptr.next; // avança para o próximo nodo
        }
        aux += "]";
        return aux;
    }

    @Override
    public int head() {
        if (count == 0) {
            throw new IndexOutOfBoundsException("Lista vazia!");
        }
        return header.next.item;
    }

    @Override
    public int dequeue() {
        if (count == 0) {
            throw new IndexOutOfBoundsException("Lista vazia!");
        }
        Node aux = header.next;
        Node prox = aux.next;
        header.next = prox;
        prox.prev = header;
        count--;
        return aux.item;
    }
}
