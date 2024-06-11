import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<E> {
	public BinaryTree<E> parent; // nó pai
	public E item; // valor armazenado
	public BinaryTree<E> left; // subárvore esquerda
	public BinaryTree<E> right; // subárvore direita

	public BinaryTree(E element) {
		parent = null;
		item = element;
		left = null;
		right = null;
	}

	public void addLeft(BinaryTree<E> tree) {
		left = tree;
		tree.parent=this;
	}

	public void addRight(BinaryTree<E> tree) {
		right = tree;
		tree.parent=this;
	}

	public BinaryTree<E> removeLeft() {
		BinaryTree<E> subtree = left;
		left = null;
		subtree.parent=null;
		return subtree;
	}

	public BinaryTree<E> removeRight() {
		BinaryTree<E> subtree = right;
		right = null;
		subtree.parent=null;
		return subtree;
	}

	// Outros métodos
	
	public int size() {
		int total = 1;
        // Completar
		return total;
	}
}
