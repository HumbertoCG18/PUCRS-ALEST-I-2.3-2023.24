#include <iostream>
#include <string>
#include "Tree.h"

int main()
{
    Tree<string> *treeB = new Tree<string>("B");
    Tree<string> *treeA = new Tree<string>("A");
    Tree<string> *treeD = new Tree<string>("D");
    Tree<string> *treeC = new Tree<string>("C");
    Tree<string> *treeE = new Tree<string>("E");
    Tree<string> *treeF = new Tree<string>("F");
    Tree<string> *treeG = new Tree<string>("G");
    treeB->addChild(treeA);
    treeB->addChild(treeD);
    treeD->addChild(treeC);
    treeD->addChild(treeE);
    treeB->addChild(treeF);
    treeE->addChild(treeG);

    cout << "Total de filhos de B: " << treeB->childrenCount() << endl;
    for (int f = 0; f < treeB->childrenCount(); f++)
        cout << treeB->getChild(f)->item << endl;    

    cout << "Pré-ordem:" << endl;
    vector<Tree<string> *> preordem = treeB->preOrder();
    for (int i = 0; i < preordem.size(); i++)
        cout << "-> " << preordem[i]->item << endl;

    cout << endl << "Pós-ordem:" << endl;
    vector<Tree<string> *> posordem = treeB->postOrder();
    for (int i = 0; i < posordem.size(); i++)
        cout << "-> " << posordem[i]->item << endl;
    cout << endl;
    cout << "Número de nós: " << treeB->size() << endl;

    cout << "Nível do B: " << treeB->level() << endl;
    cout << "Nível do C: " << treeC->level() << endl;
    cout << "Nível do F: " << treeF->level() << endl;

    cout << endl;
    cout << "Altura da árvore: " << treeB->height() << endl;

    delete treeA;
    delete treeB;
    delete treeC;
    delete treeD;
    delete treeE;
    delete treeF;
    delete treeG;
}
