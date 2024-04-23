package April._16;

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

    public void add(int element) {
        Node n = new Node(element);
        if (count != 0) // lista já tem elems?
            trailer.next = n;
        else
            header = n; // não, este é o primeiro
        trailer = n;
        count++;
    }

    public void add(int index, int element) {
        if ((index < 0) || (index > count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == count) {
            add(element);
        } else {
            Node newNode = new Node(element);
            Node prev = null;
            Node current = header;
            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }
            newNode.next = current;
            prev.next = newNode;
            count++;
        }
    }

    public int get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node current = header;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public int set(int index, int element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node current = header;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        int oldValue = current.item;
        current.item = element;
        return oldValue;
    }

    public boolean remove(int element) {
        int pos = indexOf(element);
        if (pos == -1)
            return false; // não existe na lista
        removeByIndex(pos);
        return true;
    }

    public int removeByIndex(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node removedNode;
        if (index == 0) {
            removedNode = header; //Header é só um marcador, ele não pode ser mexido, a lógica ta certa
            header = header.next;
        } else {
            Node prev = null;
            Node current = header;
            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }
            removedNode = current;
            prev.next = current.next;
            if (index == count - 1) {
                trailer = prev;
            }
        }
        count--;
        if (count == 0)
            trailer = null;
        return removedNode.item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    public int indexOf(int element) {
        Node current = header;
        for (int i = 0; i < count; i++) {
            if (current.item == element)
                return i;
            current = current.next;
        }
        return -1; // não encontrou
    }

    public void clear() {
        header = null;
        trailer = null;
        count = 0;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[ ");
        Node current = header;
        while (current != null) {
            result.append(current.item).append(" ");
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public void addFirst(int e) {
        Node newNode = new Node(e);
        newNode.next = header;
        header = newNode;
        if (count == 0) {
            trailer = newNode;
        }
        count++;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return header.item;
    }

    @Override
    public int getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return trailer.item;
    }

    @Override
    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        int removedItem = header.item;
        header = header.next;
        count--;
        if (count == 0) {
            trailer = null;
        }
        return removedItem;
    }

    @Override
    public int removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        int removedItem;
        if (count == 1) {
            removedItem = header.item;
            header = null;
            trailer = null;
        } else {
            Node prev = null;
            Node current = header;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            removedItem = current.item;
            prev.next = null;
            trailer = prev;
        }
        count--;
        return removedItem;
    }
}