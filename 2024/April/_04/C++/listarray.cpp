#include <iostream>
#include <cmath>
#include <string>
#include <sstream>
#include "listarray.h"

using namespace std;

// Construtor default: inicializa com capacidade igual a TAM_PADRAO
ListArray::ListArray()
{
    tamVet = TAM_PADRAO;
    count = 0;
    data = new int[tamVet]; //data = (int*) malloc( sizeof(int) * tamVet );
}

// Construtor com capacidade inicial
ListArray::ListArray(int tam)
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
* Esvazia a lista.
*/
void ListArray::clear()
{
    tamVet = TAM_PADRAO;
    count = 0;
    delete[] data;          // Libera os dados da lista antiga - free(data);
    data = new int[tamVet]; // Aloca a lista nova - data = (int*) malloc( sizeof(int) * tamVet );
}

/**
* Retorna true se a lista nao contem elementos.
* 
* @return true se a lista nao contem elementos
*/
bool ListArray::isEmpty()
{
    return count == 0;
}

/**
* Retorna o numero de elementos armazenados na lista.
* 
* @return o numero de elementos da lista
*/
int ListArray::size()
{
    return count;
}

/**
* Adiciona um elemento ao final da lista.
* 
* @param element elemento a ser adicionado ao final da lista
*/
void ListArray::add(int element)
{
    if (count == tamVet)
        setCapacity(tamVet * 2);

    data[count] = element;
    count++;
}

/**
* Adiciona um elemento antes de uma pos. específica
* 
* @param index   posição a inserir o novo elemento
* @param element elemento a ser adicionado
* 
*/
void ListArray::add(int index, int element)
{
    if ((index < 0) || (index > count))
    {
        throw "Índice inválido";
    }
    if (count == tamVet)
        setCapacity(tamVet * 2);
    for (int i = count - 1; i >= index; i--)
        data[i + 1] = data[i];
    data[index] = element;
    count++;
}

/**
* Retorna o elemento de uma determinada posicao da lista.
* 
* @param index a posicao da lista
* @return o elemento da posicao especificada
* @throws exception se (index < 0 || index >= size())
*/
int ListArray::get(int index)
{
    if (index < 0 || index >= count)
    {
        throw 0;
    }
    return data[index];
}

// Redefine o tamanho da lista.
// Copia os dados da lista antiga para a lista nova.
// Caso a lista nova seja menor, os dados excedentes serao perdidos.
// Ao final do metodo, os dados da lista antiga sao liberados
void ListArray::setCapacity(int newCapacity)
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
int ListArray::set(int index, int element)
{
    if ((index < 0) || (index >= count))
    {
        throw "Índice inválido!";
    }
    int aux = data[index];
    data[index] = element;
    return aux;
}

/**
 * Procura pelo elemento passado por parametro na lista e retorna true se a
 * lista contem este elemento.
 * @param element o elemento a ser procurado
 * @return true se a lista contem o elemento passado por parametro
 */
bool ListArray::contains(int element)
{
    return indexOf(element) != -1;
}

/**
 * Procura pelo elemento passado por parametro na lista, remove e retorna true se a
 * lista continha este elemento.
 * @param element o elemento a ser procurado
 * @return true se conseguir remover
 */
bool ListArray::remove(int element)
{
    for (int pos = 0; pos < count; pos++)
    {
        if (data[pos] == element)
        {
            for (; pos < count - 1; pos++)
            {
                data[pos] = data[pos + 1];
            }
            count--;
            return true;
        }
    }
    return false;
}

/**
 * Procura pelo elemento passado por parametro na lista e retorna sua posição,
 * se encontrar
 * @param element o elemento a ser procurado
 * @return posição se encontrado, -1 se não encontrado
 */
int ListArray::indexOf(int element)
{
    for (int pos = 0; pos < count; pos++)
        if (data[pos] == element)
            return pos;
    return -1;
}

string ListArray::toString()
{
    ostringstream aux;
    aux << "[ ";
    for (int pos = 0; pos < count; pos++)
        aux << data[pos] << " ";
    aux << "]";
    return aux.str();
}

/**
* Inverte o conteúdo da lista
*/
void ListArray::reverse()
{
    int i = 0;
    int j = count - 1;
    // for(i=0; i<count/2; i++)
    while (i < j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        i++;
        j--;
    }
}

/**
     * Procura um elemento e retorna o total de ocorrências
     * 
     * @param element elemento a ser encontrado
     * @return total de ocorrências
     */
int ListArray::countOccurrences(int e)
{
    int total = 0;
    for (int pos = 0; pos < count; pos++)
        if (data[pos] == e)
            total++;
    return total;
}

void ListArray::addIncreasingOrder(int element)
{
    for (int pos = 0; pos < count; pos++)
    {
        if (element < data[pos])
        {
            add(pos, element);
            return;
        }
    }
    add(element);
}

void ListArray::addDecreasingOrder(int element)
{
    for (int pos = 0; pos < count; pos++)
    {
        if (element > data[pos])
        {
            add(pos, element);
            return;
        }
    }
    add(element);
}
