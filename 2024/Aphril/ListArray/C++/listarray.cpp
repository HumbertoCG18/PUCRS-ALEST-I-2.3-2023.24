#include <iostream>
#include <math.h>
#include <stdlib.h>
#include "ListTAD.h"

using namespace std;

#define TAM_PADRAO 10

// ******************************************
//  Classe ListArray
// ******************************************

class ListArray : public ListTAD {
    private:
        int *data;
        int count;
        int tamVet;
    public:
        ListArray();
        ListArray(int tam);
        void clear();
        bool isEmpty();
        int size();
        void add(int element);
        int get(int index);
        bool remove(int element);
        int indexOf(int element);
        void setCapacity(int newCapacity);
        int set(int index, int element);
        bool contains(int element);
        int capacity();
};

// Construtor
ListArray::ListArray() {
    tamVet = TAM_PADRAO;
    count = 0;
    data = new int[tamVet]; //data = (int*) malloc( sizeof(int) * tamVet );
}

// Construtor
ListArray::ListArray(int tam) {
    if (tam<=0)
        tamVet = TAM_PADRAO;
    else {
        tamVet = tam;
    }
    data = new int[tamVet]; // data = (int*) malloc( sizeof(int) * tamVet );
    count = 0;
}

// Esvazia a lista.
void ListArray::clear(){
    tamVet = TAM_PADRAO;
    count = 0;
    delete[] data; // Libera os dados da lista antiga - free(data);
    data =  new int[tamVet]; // Aloca a lista nova - data = (int*) malloc( sizeof(int) * tamVet );
}

// Retorna true se a lista nao contem elementos, e false caso contrario.
bool ListArray::isEmpty(){
    // implemente
}

// Retorna o numero de elementos armazenados na lista.
int ListArray::size(){
    return count;
}

// Adiciona um elemento ao final da lista.
void ListArray::add(int element) {
    if (count == tamVet)
        setCapacity(tamVet * 2);

    data[count] = element;
    count++;
}

// Retorna o elemento de uma determinada posicao da lista.
int ListArray::get(int index) {
    if (index<0 || index>=count) {
        throw 0;
    }
    return data[index];
}

// Redefine o tamanho da lista.
// Copia os dados da lista antiga para a lista nova.
// Caso a lista nova seja menor, os dados excedentes serao perdidos.
// Ao final do metodo, os dados da lista antiga sao liberados
void ListArray::setCapacity(int newCapacity) {
        if (newCapacity != tamVet) {
            int min = 0;
            int *newData = new int[newCapacity]; // int *newData = (int*) malloc( sizeof(int) * newCapacity );
            if (tamVet < newCapacity) {
                min = tamVet;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            delete[] data; // Libera os dados da lista antiga - free(data);
            data = newData;
        }
}

/**
 * Substitui o elemento armazenado em uma determinada posicao da lista pelo
 * elemento passado por parametro, retornando o elemento que foi substituido.
 * @param index a posicao da lista
 * @param element o elemento a ser armazenado na lista
 * @return o elemento armazenado anteriormente na posicao da lista
 * @throws exception se (index < 0 || index >= size())
 */
int ListArray::set(int index, int element) {
       // Implemente este metodo
}

/**
 * Procura pelo elemento passado por parametro na lista e retorna true se a
 * lista contem este elemento.
 * @param element o elemento a ser procurado
 * @return true se a lista contem o elemento passado por parametro
 */
bool ListArray::contains(int element) {
   // Implemente este metodo
}

/**
 * Procura pelo elemento passado por parametro na lista, remove e retorna true se a
 * lista continha este elemento.
 * @param element o elemento a ser procurado
 * @return true se conseguir remover
 */
bool ListArray::remove(int element) {
    // Implemente
}

int ListArray::capacity() {
    return tamVet;
}

/**
 * Procura pelo elemento passado por parametro na lista e retorna sua posição,
 * se encontrar
 * @param element o elemento a ser procurado
 * @return posição se encontrado, -1 se não encontrado
 */
int ListArray::indexOf(int element) {
    // Implemente
}


// ******************************************
//  main
// ******************************************
int main()
{
        ListArray lista;

        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);

        cout << "Elemento armazenado na primeira posicao da lista: " << lista.get(0) << endl;
        cout << "Elemento armazenado na ultima posicao da lista: " << lista.get(lista.size()-1) << endl;
}
