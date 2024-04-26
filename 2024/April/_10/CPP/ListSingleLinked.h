#ifndef _LISTASE
#define _LISTASE

#include "ListTAD.h"
#include "Node.h"

// ****************************
// Lista Simplesmente Encadeada

class ListSingleLinked : public ListTAD { 

    // Referência para o primeiro elemento da lista encadeada
    Node *head;
    // Referência para o último elemento da lista encadeada
    Node *tail;
    // Contador para a quantidade de elementos que a lista contém
    int count;
    
public:
    ListSingleLinked();
    void add(int element);
    void add(int index, int element);
    int get(int index);
    int set(int index, int element);
    bool remove(int element);
    int removeByIndex(int index);
    bool isEmpty();
    int size();
    bool contains(int element);
    int indexOf(int element);
    void clear();
    std::string toString();
};

#endif
