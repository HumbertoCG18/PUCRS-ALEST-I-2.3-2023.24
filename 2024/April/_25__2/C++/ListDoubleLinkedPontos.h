#ifndef _LISTADE
#define _LISTADE

#include "ListTADPontos.h"
#include "Node.h"

// ****************************
// Lista Duplamente Encadeada

class ListDoubleLinkedPontos : public ListTADPontos
{

    // Referência para o sentinela de início
    Node *header;
    // Referência para o sentinela de fim
    Node *trailer;
    // Contador para a quantidade de elementos que a lista contém
    int count;

public:
    ListDoubleLinkedPontos();
    void add(Ponto element);
    void add(int index, Ponto element);
    Ponto get(int index);
    Ponto set(int index, Ponto element);
    bool remove(Ponto element);
    Ponto removeByIndex(int index);
    bool isEmpty();
    int size();
    bool contains(Ponto element);
    int indexOf(Ponto element);
    void clear();
    std::string toString();
    /*
    void addFirst(int e);
    int getFirst();
    int getLast();
    int removeFirst();
    int removeLast();
    */
};

#endif
