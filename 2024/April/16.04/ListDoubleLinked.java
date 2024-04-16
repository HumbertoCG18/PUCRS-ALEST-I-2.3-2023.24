public class ListDoubleLinked implements ListTAD {

    private Node header;
    private Node trailer;
    private int count;

    private class Node {
        public int item;
        public Node next;

        public Node(int element) {
            this.item = element;
            this.next = null;
        }
    }

    public ListDoubleLinked() {
        clear();
    }

    @Override
    public void add(int element) {
        /*
        Node n = new Node(element);
        if (count != 0) // lista já tem elems?
            tail.next = n;
        else
            head = n; // não, este é o primeiro
        tail = n;
        count++;
        */
    }

    @Override
    public void add(int index, int element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node n = new Node(element);
        /*
        if (index == 0) { // inserção no início?
            n.next = head;
            head = n;
        } else {
            Node ant = null;
            Node target = head;
            for (int pos = 0; pos < index; pos++) {
                ant = target;
                target = target.next;
            }
            ant.next = n;
            n.next = target;
        }
        */
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * 
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    @Override
    public int get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        /*
        Node ptr = head;
        for (int pos = 0; pos < index; pos++)
            ptr = ptr.next;
        return ptr.element;
        */
    }

    /**
     * Substitui o elemento armazenado em uma determinada posicao da lista pelo
     * elemento passado por parametro, retornando o elemento que foi substituido.
     * 
     * @param index   a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    @Override
    public int set(int index, int element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        /*
        Node ptr = head;
        for (int pos = 0; pos < index; pos++)
            ptr = ptr.next;
        int temp = ptr.element; // salva o valor armazenado lá...
        ptr.element = element;
        return temp; // ...e retorna ele
        */
    }

    @Override
    public boolean remove(int element) {
        int pos = indexOf(element);
        if (pos == -1)
            return false; // não existe na lista
        removeByIndex(pos);
        return true;
    }

    @Override
    public int removeByIndex(int index) {
        /*
        Node aux = head;
        // Se for o início, basta avançar o head
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = head;
            aux = head.next;
            for (int pos = 1; pos < index; pos++) {
                prev = aux;
                aux = aux.next;
            }
            // Remove o elemento
            prev.next = aux.next;
            // Se for o final da lista,
            // ajusta o tail
            if (index == count - 1)
                tail = prev;
        }
        count--;
        // Se a lista ficar vazia (count==0),
        // garante que o tail também será NULL
        if (count == 0)
            tail = null;
        return aux.element;
        */
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
    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(int element) {
        /*
        Node ptr = head;
        for (int pos = 0; pos < count; pos++) {
            if (ptr.element == element)
                return pos;
            ptr = ptr.next;
        }
        return -1; // não encontrou
        */
    }

    @Override
    public void clear() {
        /*
        head = null;
        tail = null;
        count = 0;
        */
    }

    /**
     * Retorna o conteúdo da lista como uma string
     * 
     * @return uma string com os elementos da lista
     */
    @Override
    public String toString() {
        /*
        String aux = "[ ";
        Node ptr = head;
        while (ptr != null) {
            aux = aux + ptr.element + " ";
            ptr = ptr.next; // avança para o próximo nodo
        }
        aux += "]";
        return aux;
        */
    }

}
