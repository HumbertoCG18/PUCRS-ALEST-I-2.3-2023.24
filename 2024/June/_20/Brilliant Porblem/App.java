public class App {

	public static BinaryTree<Integer> gera(int height, int val) {
		BinaryTree<Integer> temp = new BinaryTree<>(val);
		temp.height = height;
		if (height == 0) {
			temp.left = null;
			temp.right = null;
		} else {
			temp.left = gera(height - 1, val * 2);
			temp.right = gera(height - 1, val * 2 + 1);
		}
		return temp;
	}

	public static void main(String[] args) {

		// Gera uma árvore binária com altura=4
		// (15 nós)
		BinaryTree<Integer> root = gera(3, 1);
		// System.out.println(root.toDOT(root));
		for (int bola = 1; bola < 6; bola++)
			System.out.println("Bola " + bola + ": " + root.traverse(root));
	}
}
