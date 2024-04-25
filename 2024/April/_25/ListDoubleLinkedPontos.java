package April._25;

import java.util.NoSuchElementException;

public class ListDoubleLinkedPontos implements ListTADPontos {

    private Node header;
    private Node trailer;
    private int count;

    private class Node {
        public Ponto item;
        public Node next;
        public Node prev;

        public Node(Ponto element, Node prev, Node next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public ListDoubleLinkedPontos() {
        clear();
    }

    @Override
    public void add(Ponto element) {
        add(size(), element);
    }

    @Override
    public void add(int index, Ponto element) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node newNode;
        if (index == count) {
            newNode = new Node(element, trailer.prev, trailer);
            trailer.prev.next = newNode;
            trailer.prev = newNode;
        } else {
            Node current = getNode(index);
            newNode = new Node(element, current.prev, current);
            current.prev.next = newNode;
            current.prev = newNode;
        }
        count++;
    }

    @Override
    public Ponto get(int index) {
        return getNode(index).item;
    }

    @Override
    public Ponto set(int index, Ponto element) {
        Node node = getNode(index);
        Ponto oldValue = node.item;
        node.item = element;
        return oldValue;
    }

    @Override
    public boolean remove(Ponto element) {
        int index = indexOf(element);
        if (index != -1) {
            removeByIndex(index);
            return true;
        }
        return false;
    }

    @Override
    public Ponto getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia!");
        }
        return header.next.item;
    }

    @Override
    public Ponto removeByIndex(int index) {
        Node node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        count--;
        return node.item;
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
    public boolean contains(Ponto element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(Ponto element) {
        Node current = header.next;
        for (int i = 0; i < count; i++) {
            if (current.item.equals(element)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
public Ponto getLast() {
    if (isEmpty()) {
        throw new NoSuchElementException("Lista vazia!");
    }
    return trailer.prev.item;
}

@Override
public Ponto removeLast() {
    if (isEmpty()) {
        throw new NoSuchElementException("Lista vazia!");
    }
    Node last = trailer.prev;
    Node secondToLast = last.prev;
    secondToLast.next = trailer;
    trailer.prev = secondToLast;
    count--;
    return last.item;
}

@Override
public void addFirst(Ponto element) {
    Node newNode = new Node(element, header, header.next);
    header.next.prev = newNode;
    header.next = newNode;
    count++;
}

@Override
public Ponto removeFirst() {
    if (isEmpty()) {
        throw new NoSuchElementException("Lista vazia!");
    }
    Node first = header.next;
    Node second = first.next;
    header.next = second;
    second.prev = header;
    count--;
    return first.item;
}

    @Override
    public void clear() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.next = trailer;
        count = 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[ ");
        Node current = header.next;
        while (current != trailer) {
            builder.append(current.item).append(" ");
            current = current.next;
        }
        builder.append("]");
        return builder.toString();
    }

    private Node getNode(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node current = header.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
