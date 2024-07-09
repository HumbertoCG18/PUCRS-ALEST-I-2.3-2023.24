class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self):
        self.root = None

    def count_only_right_child(self):
        return self._count_only_right_child_recursive(self.root)

    def _count_only_right_child_recursive(self, node):
        if node is None:
            return 0

        count = 0

        if node.left is None and node.right is not None:
            count = 1

        count += self._count_only_right_child_recursive(node.left)
        count += self._count_only_right_child_recursive(node.right)

        return count

    def insert(self, value):
        if self.root is None:
            self.root = TreeNode(value)
        else:
            self._insert_recursive(self.root, value)

    def _insert_recursive(self, node, value):
        if value < node.value:
            if node.left is None:
                node.left = TreeNode(value)
            else:
                self._insert_recursive(node.left, value)
        else:
            if node.right is None:
                node.right = TreeNode(value)
            else:
                self._insert_recursive(node.right, value)

# Código de teste
if __name__ == "__main__":
    tree = BinaryTree()
    values = [50, 10, 30, 60, 15, 5, 2]
    for value in values:
        tree.insert(value)

    count = tree.count_only_right_child()
    print("Number of nodes with only right child:", count)
