#ifndef LIST_ARRAY_H
#define LIST_ARRAY_H

#include <string>
#include "ListTADPontos.h"

using namespace std;

#define TAM_PADRAO 10

// ******************************************
//  Classe ListArray
// ******************************************

class ListArrayPontos : public ListTADPontos
{
private:
    Ponto *data;
    int count;
    int tamVet;
    void setCapacity(int newCapacity);

public:
    ListArrayPontos();
    ListArrayPontos(int tam);
    ~ListArrayPontos();
    void clear();
    bool isEmpty();
    int size();
    void add(Ponto element);
    void add(int index, Ponto element);
    Ponto get(int index);
    bool remove(Ponto element);
    Ponto removeByIndex(int index);
    int indexOf(Ponto element);
    Ponto set(int index, Ponto element);
    bool contains(Ponto element);
    string toString();
};

#endif
