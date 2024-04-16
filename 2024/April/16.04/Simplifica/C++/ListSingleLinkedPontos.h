#ifndef _LISTASE
#define _LISTASE

#include "ListTADPontos.h"
#include "NodeSingle.h"

// ****************************
// Lista Simplesmente Encadeada

class ListSingleLinkedPontos : public ListTADPontos
{

private:
    // Referência para o primeiro elemento da lista encadeada
    NodeSingle *head;
    // Referência para o último elemento da lista encadeada
    NodeSingle *tail;
    // Contador para a quantidade de elementos que a lista contém
    int count;

public:
    ListSingleLinkedPontos();
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
};

#endif
