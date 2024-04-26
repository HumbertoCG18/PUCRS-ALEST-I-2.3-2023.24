#ifndef LIST_TAD_H
#define LIST_TAD_H
// ******************************************
//  Classe abstrata ListTAD e struct Ponto
// ******************************************

#include "Ponto.h"

class ListTADPontos
{
public:
    virtual ~ListTADPontos() { };
    virtual void add(Ponto element) = 0;
    virtual void add(int index, Ponto element) = 0;
    virtual Ponto get(int index) = 0;
    virtual Ponto set(int index, Ponto element) = 0;
    virtual bool remove(Ponto element) = 0;
    virtual Ponto removeByIndex(int index) = 0;
    virtual bool isEmpty() = 0;
    virtual int size() = 0;
    virtual bool contains(Ponto element) = 0;
    virtual int indexOf(Ponto element) = 0;
    virtual void clear() = 0;
    /*
    virtual void addFirst(int e) = 0;
    virtual int getFirst() = 0;
    virtual int getLast() = 0;
    virtual int removeFirst() = 0;
    virtual int removeLast() = 0;
    */
};

// ListTADPontos::~ListTADPontos() {}

#endif