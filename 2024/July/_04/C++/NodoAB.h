#ifndef _NodoAB
#define _NodoAB

#include <list>

using namespace std;

template<class T>
struct NodoAB {
    T element;
    NodoAB<T>* parent;
    NodoAB<T>* left;
    NodoAB<T>* right;

    NodoAB(T elem);
};

template<class T>
NodoAB<T>::NodoAB(T elem)
{
  left = nullptr;
  right = nullptr;
  parent = nullptr;
  element = elem;
}

#endif
