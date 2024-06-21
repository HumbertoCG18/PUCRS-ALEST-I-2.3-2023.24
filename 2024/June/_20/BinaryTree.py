import sys
sys.stdout.reconfigure(encoding='utf-8')

class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.value = key

class BinaryTree:
    def __init__(self):
        self.root = None

    def findLCA(self, root, n1, n2):
        if root is None:
            return None

        if root.value == n1 or root.value == n2:
            return root

        left_lca = self.findLCA(root.left, n1, n2)
        right_lca = self.findLCA(root.right, n1, n2)

        if left_lca and right_lca:
            return root

        return left_lca if left_lca is not None else right_lca

    def anestral(self, i, j):
        lca = self.findLCA(self.root, i, j)
        return lca.value if lca else None

    def findPath(self, root, path, k):
        if root is None:
            return False

        path.append(root.value)

        if root.value == k:
            return True

        if (root.left is not None and self.findPath(root.left, path, k)) or (root.right is not None and self.findPath(root.right, path, k)):
            return True

        path.pop()
        return False

    def caminho(self, val):
        path = []
        if self.findPath(self.root, path, val):
            print(" -> ".join(map(str, path)))
        else:
            print(f"Valor {val} não encontrado na árvore.")

    def maxPathSumUtil(self, root):
        if root is None:
            return 0

        left = self.maxPathSumUtil(root.left)
        right = self.maxPathSumUtil(root.right)

        return root.value + max(left, right)

    def maxsoma(self):
        return self.maxPathSumUtil(self.root)

    def isBSTUtil(self, node, left, right):
        if node is None:
            return True

        if node.value <= left or node.value >= right:
            return False

        return (self.isBSTUtil(node.left, left, node.value) and
                self.isBSTUtil(node.right, node.value, right))

    def isABP(self):
        return self.isBSTUtil(self.root, float('-inf'), float('inf'))

# Criando a árvore: { 3, { 1, {} ,{4, {},{}},{} } }
tree = BinaryTree()
tree.root = Node(3)
tree.root.left = Node(1)
tree.root.left.right = Node(4)

# Testando os métodos
print("Ancestral comum mais próximo de 1 e 4:", tree.anestral(1, 4))
print("Caminho até o nodo com valor 4:")
tree.caminho(4)
print("Maior soma de caminho da raiz até uma folha:", tree.maxsoma())
print("A árvore é uma árvore binária de pesquisa?", "Sim" if tree.isABP() else "Não")
    