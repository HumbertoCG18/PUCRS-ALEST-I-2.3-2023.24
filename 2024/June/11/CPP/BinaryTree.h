#ifndef BINTREE_H
#define BINTREE_H

#include <vector>

using namespace std;

template<class T>
class BinaryTree {

    public:
      BinaryTree(T item);
      void addLeft(BinaryTree<T>* tree);
      void addRight(BinaryTree<T>* tree);
      BinaryTree<T>* removeLeft();
      BinaryTree<T>* removeRight();
      void clear();
      int size();

      BinaryTree<T>* parent;
      T item;

    private:
      BinaryTree<T>* left;
      BinaryTree<T>* right;
      void clear(BinaryTree<T>* tree); // recursive clear
};
  
template<class T>
BinaryTree<T>::BinaryTree(T item) {
    this->parent = nullptr;
    this->item = item;
    this->left = this->right = nullptr;
}

template<class T>
void BinaryTree<T>::clear() {
    clear(this);
}

template<class T>
void BinaryTree<T>::clear(BinaryTree<T>* tree) {
    if(tree->left != nullptr)
        clear(tree->left);
    if(tree->right != nullptr)
        clear(tree->right);
    //cout << "clear: "<< tree->item << endl;
    delete tree;
}

template<class T>
void BinaryTree<T>::addLeft(BinaryTree<T>* tree) {
    left = tree;
    tree->parent = this;
}

template<class T>
void BinaryTree<T>::addRight(BinaryTree<T>* tree) {
    right = tree;
    tree->parent = this;
}

template<class T>
BinaryTree<T>* BinaryTree<T>::removeLeft() {
    if(left == nullptr) return nullptr;
    BinaryTree<T>* aux = left;
    left = nullptr;
    aux->parent = nullptr;
    return aux;
}

template<class T>
BinaryTree<T>* BinaryTree<T>::removeRight() {
    if(right == nullptr) return nullptr;
    BinaryTree<T>* aux = right;
    right = nullptr;
    aux->parent = nullptr;
    return aux;
}

template<class T>
int BinaryTree<T>::size() {
    int total = 1;
    // Completar
    return total;
}

#endif

