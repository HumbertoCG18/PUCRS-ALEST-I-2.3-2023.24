#ifndef TREE_H
#define TREE_H

#include <vector>

using namespace std;

template <class T>
class Tree
{

public:
    Tree(T item);
    void addChild(Tree<T> *tree);
    void addChild(int index, Tree<T> *tree);
    Tree<T> *removeChild(int index);
    Tree<T> *getChild(int index);
    int childrenCount();
    int size();
    int level();
    int height();
    vector<Tree<T> *> preOrder();
    vector<Tree<T> *> postOrder();

    Tree<T> *parent;
    T item;

private:
    vector<Tree<T> *> children;
    void preOrderRecursive(Tree<T> *atual, vector<Tree<T> *> &lista);
    void postOrderRecursive(Tree<T> *atual, vector<Tree<T> *> &lista);
    int sizeRecursive(Tree<T>* atual);
    int heightRecursive(Tree<T>* atual);
};

template <class T>
Tree<T>::Tree(T item)
{
    this->parent = nullptr;
    this->item = item;
}

template <class T>
void Tree<T>::addChild(Tree<T> *tree)
{
    children.push_back(tree);
    tree->parent = this;
}

template <class T>
void Tree<T>::addChild(int index, Tree<T> *tree)
{
    children.insert(children.begin() + index, tree);
    tree->parent = this;
}

template <class T>
Tree<T> *Tree<T>::removeChild(int index)
{
    Tree<T> *child = children.erase(index);
    child->parent = nullptr;
    return child;
}

template <class T>
Tree<T> *Tree<T>::getChild(int index)
{
    return children[index];
}

template <class T>
int Tree<T>::childrenCount()
{
    return children.size();
}

template <class T>
int Tree<T>::size()
{
    return sizeRecursive(this);
}

template <class T>
int Tree<T>::height() {
        return heightRecursive(this);
    }

template<class T>
int Tree<T>::heightRecursive(Tree<T>* atual) {
    int maior = 0;
    if(atual->childrenCount() == 0)
        return atual->level();
    for (int i = 0; i < atual->childrenCount(); i++) {
        int alt = heightRecursive(atual->getChild(i));
        if(alt > maior) maior = alt;            
    }
    return maior;
}

template <class T>
int Tree<T>::level()
{
    int lev = 0;
    Tree<T>* atual = this;
    // Enquanto não chegar à raiz
    while(atual->parent != nullptr) {
        lev++;
        atual = atual->parent;
    }
    return lev;
}

template<class T>
int Tree<T>::sizeRecursive(Tree<T>* atual)
{
    int total = 1;
    cout << "Estou em " << atual->item << endl;    
    for (int i = 0; i < atual->childrenCount(); i++)
        total += sizeRecursive(atual->getChild(i));
    cout << atual->item << " vai retornar: " << total << endl;
    return total;
}

template <class T>
vector<Tree<T> *> Tree<T>::preOrder()
{
    vector<Tree<T> *> lista;
    preOrderRecursive(this, lista);
    return lista;
}

template <class T>
void Tree<T>::preOrderRecursive(Tree<T> *atual, vector<Tree<T> *> &lista)
{
    lista.push_back(atual);
    for (int i = 0; i < atual->childrenCount(); i++)
        preOrderRecursive(atual->getChild(i), lista);
}

template <class T>
vector<Tree<T> *> Tree<T>::postOrder()
{
    vector<Tree<T> *> lista;
    postOrderRecursive(this, lista);
    return lista;
}

template <class T>
void Tree<T>::postOrderRecursive(Tree<T> *atual, vector<Tree<T> *> &lista)
{
    for (int i = 0; i < atual->childrenCount(); i++)
        postOrderRecursive(atual->getChild(i), lista);
    lista.push_back(atual);
}

#endif
