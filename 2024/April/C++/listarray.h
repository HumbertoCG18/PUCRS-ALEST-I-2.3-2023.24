#ifndef LIST_ARRAY_H
#define LIST_ARRAY_H

#include <string>
#include "ListTAD.h"

using namespace std;

#define TAM_PADRAO 10

// ******************************************
//  Classe ListArray
// ******************************************

class ListArray : public ListTAD
{
private:
    int *data;
    int count;
    int tamVet;
    void setCapacity(int newCapacity);

public:
    ListArray();
    ListArray(int tam);
    void clear();
    bool isEmpty();
    int size();
    void add(int element);
    void add(int index, int element);
    int get(int index);
    bool remove(int element);
    int indexOf(int element);
    int set(int index, int element);
    bool contains(int element);
    string toString();
    // Exercícios
    void reverse();
    int countOccurrences(int e);
    void addIncreasingOrder(int element);
    void addDecreasingOrder(int element);
};

#endif
