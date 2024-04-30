#ifndef _LISTADE
#define _LISTADE

#include "ListTAD.h"
#include "Node.h"

// ****************************
// Lista Duplamente Encadeada

class ListDoubleLinked : public ListTAD { 

    // Referência para o sentinela de início
    Node *header;
    // Referência para o sentinela de fim
    Node *trailer;
    // Contador para a quantidade de elementos que a lista contém
    int count;
    
public:
    ListDoubleLinked();
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
