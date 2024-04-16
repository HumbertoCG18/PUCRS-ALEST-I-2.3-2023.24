#include <iostream>
#include <cmath>
#include <string>
#include <sstream>
#include "ListArrayPontos.h"

using namespace std;

// Construtor default: inicializa com capacidade igual a TAM_PADRAO
ListArrayPontos::ListArrayPontos()
{
    tamVet = TAM_PADRAO;
    count = 0;
    data = new Ponto[tamVet]; //data = (int*) malloc( sizeof(int) * tamVet );
}

// Construtor com capacidade inicial
ListArrayPontos::ListArrayPontos(int tam)
{
    if (tam <= 0)
        tamVet = TAM_PADRAO;
    else
    {
        tamVet = tam;
    }
    data = new Ponto[tamVet]; // data = (int*) malloc( sizeof(int) * tamVet );
    count = 0;
}

/**
 * Destrutor
 */
ListArrayPontos::~ListArrayPontos()
{
    cout << "Destroying..." << endl;
    delete[] data;
}

/**
* Esvazia a lista.
*/
void ListArrayPontos::clear()
{
    tamVet = TAM_PADRAO;
    count = 0;
    delete[] data;          // Libera os dados da lista antiga - free(data);
    data = new Ponto[tamVet]; // Aloca a lista nova - data = (int*) malloc( sizeof(int) * tamVet );
}

/**
* Retorna true se a lista nao contem elementos.
* 
* @return true se a lista nao contem elementos
*/
bool ListArrayPontos::isEmpty()
{
    return count == 0;
}

/**
* Retorna o numero de elementos armazenados na lista.
* 
* @return o numero de elementos da lista
*/
int ListArrayPontos::size()
{
    return count;
}

/**
* Adiciona um elemento ao final da lista.
* 
* @param element elemento a ser adicionado ao final da lista
*/
void ListArrayPontos::add(Ponto element)
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
void ListArrayPontos::add(int index, Ponto element)
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
Ponto ListArrayPontos::get(int index)
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
void ListArrayPontos::setCapacity(int newCapacity)
{
    if (newCapacity != tamVet)
    {
        int min = 0;
        Ponto *newData = new Ponto[newCapacity]; // int *newData = (int*) malloc( sizeof(int) * newCapacity );
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
        tamVet = newCapacity;
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
Ponto ListArrayPontos::set(int index, Ponto element)
{
    if ((index < 0) || (index >= count))
    {
        throw "Índice inválido!";
    }
    Ponto aux = data[index];
    data[index] = element;
    return aux;
}

/**
 * Procura pelo elemento passado por parametro na lista e retorna true se a
 * lista contem este elemento.
 * @param element o elemento a ser procurado
 * @return true se a lista contem o elemento passado por parametro
 */
bool ListArrayPontos::contains(Ponto element)
{
    return indexOf(element) != -1;
}

/**
 * Procura pelo elemento passado por parametro na lista, remove e retorna true se a
 * lista continha este elemento.
 * @param element o elemento a ser procurado
 * @return true se conseguir remover
 */
bool ListArrayPontos::remove(Ponto element)
{
    for (int pos = 0; pos < count; pos++)
    {
        if (data[pos].x == element.x && data[pos].y == element.y)
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

Ponto ListArrayPontos::removeByIndex(int index) {
    if ((index < 0) || (index >= count))
    {
        throw "Índice inválido!";
    }
    Ponto val = data[index];
    for (int pos=index; pos < count - 1; pos++) {
        data[pos] = data[pos + 1];
    }
    count--;
    return val;
}

/**
 * Procura pelo elemento passado por parametro na lista e retorna sua posição,
 * se encontrar
 * @param element o elemento a ser procurado
 * @return posição se encontrado, -1 se não encontrado
 */
int ListArrayPontos::indexOf(Ponto element)
{
    for (int pos = 0; pos < count; pos++)
        if (data[pos].x == element.x && data[pos].y == element.y)
            return pos;
    return -1;
}

string ListArrayPontos::toString()
{
    ostringstream aux;
    aux << "[ ";
    for (int pos = 0; pos < count; pos++)
        aux << "(" << data[pos].x << "," << data[pos].y << ") ";
    aux << "]";
    return aux.str();
}