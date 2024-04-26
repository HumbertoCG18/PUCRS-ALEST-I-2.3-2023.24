#include <iostream>
#include <cmath>
#include <string>
#include <sstream>
#include "queuearray.h"

using namespace std;

// Construtor default: inicializa com capacidade igual a TAM_PADRAO
QueueArray::QueueArray()
{
    tamVet = TAM_PADRAO;
    count = 0;
    data = new int[tamVet]; //data = (int*) malloc( sizeof(int) * tamVet );
}

// Construtor com capacidade inicial
QueueArray::QueueArray(int tam)
{
    if (tam <= 0)
        tamVet = TAM_PADRAO;
    else
    {
        tamVet = tam;
    }
    data = new int[tamVet]; // data = (int*) malloc( sizeof(int) * tamVet );
    count = 0;
}

/**
* Esvazia a fila.
*/
void QueueArray::clear()
{
    tamVet = TAM_PADRAO;
    count = 0;
    delete[] data;          // Libera os dados da fila antiga - free(data);
    data = new int[tamVet]; // Aloca a fila nova - data = (int*) malloc( sizeof(int) * tamVet );
}

/**
* Retorna true se a fila nao contem elementos.
* 
* @return true se a fila nao contem elementos
*/
bool QueueArray::isEmpty()
{
    return count == 0;
}

/**
* Retorna o numero de elementos armazenados na fila.
* 
* @return o numero de elementos da fila
*/
int QueueArray::size()
{
    return count;
}

/**
* Adiciona um elemento ao final da fila.
* 
* @param element elemento a ser adicionado ao final da fila
*/
void QueueArray::enqueue(int element)
{
    if (count == tamVet)
        setCapacity(tamVet * 2);

    data[count] = element;
    count++;
}

/**
* Retorna o elemento de uma determinada posicao da fila.
* 
* @param index a posicao da fila
* @return o elemento da posicao especificada
* @throws exception se (index < 0 || index >= size())
*/
int QueueArray::head()
{
    if (count == 0)
    {
        throw 0;
    }
    return data[0];
}

// Redefine o tamanho da fila.
// Copia os dados da fila antiga para a fila nova.
// Caso a fila nova seja menor, os dados excedentes serao perdidos.
// Ao final do metodo, os dados da fila antiga sao liberados
void QueueArray::setCapacity(int newCapacity)
{
    if (newCapacity != tamVet)
    {
        int min = 0;
        int *newData = new int[newCapacity]; // int *newData = (int*) malloc( sizeof(int) * newCapacity );
        if (tamVet < newCapacity)
        {
            min = tamVet;
        }
        else
        {
            min = newCapacity;
        }
        for (int i = 0; i < min; i++)
        {
            newData[i] = data[i];
        }
        delete[] data; // Libera os dados da fila antiga - free(data);
        data = newData;
    }
}

/**
 * Remove e retorna o primeiro da fila
 * @return primeiro da fila
 */
int QueueArray::dequeue()
{
    int aux = data[0];
    for (int pos = 0; pos < count - 1; pos++)
    {
        data[pos] = data[pos + 1];
    }
    count--;
    return aux;
}

string QueueArray::toString()
{
    ostringstream aux;
    aux << "[ ";
    for (int pos = 0; pos < count; pos++)
        aux << data[pos] << " ";
    aux << "]";
    return aux.str();
}