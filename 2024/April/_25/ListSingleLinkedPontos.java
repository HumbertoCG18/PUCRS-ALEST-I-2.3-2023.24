package April._25;

import java.util.NoSuchElementException;

public class ListSingleLinkedPontos implements ListTADPontos {

    private Node head;
    private Node tail;
    private int count;

    private class Node {
        public Ponto element;
        public Node next;

        public Node(Ponto element) {
            this.element = element;
            this.next = null;
        }
    }

    public ListSingleLinkedPontos() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public void add(Ponto element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    @Override
    public void add(int index, Ponto element) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == count) {
            add(element);
        } else {
            Node newNode = new Node(element);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            count++;
        }
    }

    @Override
    public Ponto get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public Ponto set(int index, Ponto element) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Ponto previousElement = current.element;
        current.element = element;
        return previousElement;
    }

    @Override
    public boolean remove(Ponto element) {
        if (isEmpty()) {
            return false;
        }
        if (head.element.equals(element)) {
            removeFirst();
            return true;
        }
        Node current = head;
        while (current.next != null && !current.next.element.equals(element)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            count--;
            if (current.next == null) {
                tail = current;
            }
            return true;
        }
        return false;
    }

    @Override
    public Ponto removeByIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == count - 1) {
            return removeLast();
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Ponto removedElement = current.next.element;
        current.next = current.next.next;
        count--;
        return removedElement;
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
        Node current = head;
        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(Ponto element) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.element.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public void addFirst(Ponto element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    @Override
    public Ponto getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia!");
        }
        return head.element;
    }

    @Override
    public Ponto getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia!");
        }
        return tail.element;
    }

    @Override
    public Ponto removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia!");
        }
        Ponto removedElement = head.element;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        count--;
        return removedElement;
    }

    @Override
    public Ponto removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia!");
        }
        Ponto removedElement = tail.element;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        count--;
        return removedElement;
    }
}
