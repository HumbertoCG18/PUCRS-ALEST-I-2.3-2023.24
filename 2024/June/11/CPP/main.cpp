#include <iostream>
#include <string>
#include <vector>
#include "BinaryTree.h"

int main()
{
    // T={A,{B,0,0},{C,0,{D,0,0}}}
    BinaryTree<string>* ta = new BinaryTree<string>("A");
    BinaryTree<string>* tb = new BinaryTree<string>("B");
    ta->addLeft(tb);
    BinaryTree<string>* tc = new BinaryTree<string>("C");
    ta->addRight(tc);
    BinaryTree<string>* td = new BinaryTree<string>("D");
    tc->addRight(td);

    // cout << "Número de nós: " << ta->size() << endl;

    /*
    vector<string> lista = ta->traversalPre();
    cout << "Percurso pré-ordem: " << endl;

    vector<string> lista2 = ta->traversalPos();
    cout << "Percurso pós-ordem: " << endl;
        
    vector<string> lista3 = ta->traversalPos();
    cout << "Percurso em largura: " << endl;
    */
    ta->clear();
}
