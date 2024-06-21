#ifndef BINTREE_H
#define BINTREE_H

#include <vector>
#include <queue>

using namespace std;

template <class T>
class BinaryTree
{

public:
    BinaryTree(T item);
    void addLeft(BinaryTree<T> *tree);
    void addRight(BinaryTree<T> *tree);
    BinaryTree<T> *removeLeft();
    BinaryTree<T> *removeRight();
    void clear();
    int degree();
    int size();
    int level();
    int height();
    T traverse(BinaryTree<T> *root);
    vector<BinaryTree<T> *> preOrder();
    vector<BinaryTree<T> *> postOrder();
    vector<BinaryTree<T> *> inOrder();
    vector<BinaryTree<T> *> breadth();

    BinaryTree<T> *parent;
    BinaryTree<T> *left;
    BinaryTree<T> *right;
    bool toggled;
    int h;
    T item;

private:
    void clear(BinaryTree<T> *tree); // recursive clear
    int size(BinaryTree<T> *tree);
    int height(BinaryTree<T> *atual);
    void preOrder(BinaryTree<T> *atual, vector<BinaryTree<T> *> &lista);
    void postOrder(BinaryTree<T> *atual, vector<BinaryTree<T> *> &lista);
    void inOrder(BinaryTree<T> *atual, vector<BinaryTree<T> *> &lista);
};

template <class T>
BinaryTree<T>::BinaryTree(T item)
{
    this->parent = nullptr;
    this->item = item;
    this->toggled = false;
    this->left = this->right = nullptr;
}

template <class T>
void BinaryTree<T>::clear()
{
    clear(this);
}

template <class T>
void BinaryTree<T>::clear(BinaryTree<T> *tree)
{
    if (tree->left != nullptr)
        clear(tree->left);
    if (tree->right != nullptr)
        clear(tree->right);
    //cout << "clear: "<< tree->item << endl;
    delete tree;
}

template <class T>
void BinaryTree<T>::addLeft(BinaryTree<T> *tree)
{
    left = tree;
    tree->parent = this;
}

template <class T>
void BinaryTree<T>::addRight(BinaryTree<T> *tree)
{
    right = tree;
    tree->parent = this;
}

template <class T>
BinaryTree<T> *BinaryTree<T>::removeLeft()
{
    if (left == nullptr)
        return nullptr;
    BinaryTree<T> *aux = left;
    left = nullptr;
    aux->parent = nullptr;
    return aux;
}

template <class T>
BinaryTree<T> *BinaryTree<T>::removeRight()
{
    if (right == nullptr)
        return nullptr;
    BinaryTree<T> *aux = right;
    right = nullptr;
    aux->parent = nullptr;
    return aux;
}

template <class T>
int BinaryTree<T>::degree()
{
    int d = left != nullptr ? 1 : 0;
    d += right != nullptr ? 1 : 0;
    return d;
}

template <class T>
int BinaryTree<T>::size()
{
    return size(this);
}

template <class T>
int BinaryTree<T>::size(BinaryTree<T> *atual)
{
    int total = 1; // raiz + filhos
    if (atual->left != nullptr)
        total += size(atual->left);
    if (atual->right != nullptr)
        total += size(atual->right);
    return total;
}

template <class T>
int BinaryTree<T>::level()
{
    int lev = 0;
    BinaryTree<T> *atual = this;
    // Enquanto não chegar à raiz
    while (atual->parent != nullptr)
    {
        lev++;
        atual = atual->parent;
    }
    return lev;
}

template <class T>
int BinaryTree<T>::height()
{
    return height(this);
}

template <class T>
int BinaryTree<T>::height(BinaryTree<T> *atual)
{
    int maior = 0;
    if (atual == nullptr)
        return 0;
    if (atual->left == nullptr && atual->right == nullptr)
        return atual->level();
    int leftHeight = height(atual->left);
    int rightHeight = height(atual->right);
    maior = leftHeight;
    if (rightHeight > maior)
        maior = rightHeight;
    return maior;
}

template <class T>
vector<BinaryTree<T> *> BinaryTree<T>::preOrder()
{
    vector<BinaryTree<T> *> lista;
    preOrder(this, lista);
    return lista;
}

template <class T>
void BinaryTree<T>::preOrder(BinaryTree<T> *atual, vector<BinaryTree<T> *> &lista)
{
    if (atual == nullptr)
        return;
    lista.push_back(atual);
    preOrder(atual->left, lista);
    preOrder(atual->right, lista);
}

template <class T>
vector<BinaryTree<T> *> BinaryTree<T>::postOrder()
{
    vector<BinaryTree<T> *> lista;
    postOrder(this, lista);
    return lista;
}

template <class T>
void BinaryTree<T>::postOrder(BinaryTree<T> *atual, vector<BinaryTree<T> *> &lista)
{
    if (atual == nullptr)
        return;
    postOrder(atual->left, lista);
    postOrder(atual->right, lista);
    lista.push_back(atual);
}

template <class T>
vector<BinaryTree<T> *> BinaryTree<T>::inOrder()
{
    vector<BinaryTree<T> *> lista;
    inOrder(this, lista);
    return lista;
}

template <class T>
void BinaryTree<T>::inOrder(BinaryTree<T> *atual, vector<BinaryTree<T> *> &lista)
{
    if (atual == nullptr)
        return;
    inOrder(atual->left, lista);
    lista.push_back(atual);
    inOrder(atual->right, lista);
}

template <class T>
vector<BinaryTree<T> *> BinaryTree<T>::breadth()
{
    vector<BinaryTree<T> *> lista;
    queue<BinaryTree<T> *> fila;
    fila.push(this);
    while (!fila.empty())
    {
        BinaryTree<T> *aux = fila.front();
        fila.pop();
        if (aux->left != nullptr)
            fila.push(aux->left);
        if (aux->right != nullptr)
            fila.push(aux->right);
        lista.push_back(aux);
    }
    return lista;
}

template <class T>
T BinaryTree<T>::traverse(BinaryTree<T> *root)
{
    while (true)
    {
        if (root->h == 0)
            return root->item;

        root->toggled = !root->toggled;
        if (root->toggled)
            root = root->left;
        else
            root = root->right;
    }
}

#endif
