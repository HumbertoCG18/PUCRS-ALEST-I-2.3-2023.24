#include <iostream>
#include <cmath>
#include <string>
#include <sstream>

#include "ListSingleLinkedPontos.h"

using namespace std;

// Construtor
ListSingleLinkedPontos::ListSingleLinkedPontos()
{
    head = NULL;
    tail = NULL;
    count = 0;
    // clear();
}

/**
* Esvazia a lista.
*/
void ListSingleLinkedPontos::clear()
{
    head = NULL;
    tail = NULL;
    count = 0;
}

/**
* Retorna true se a lista nao contem elementos.
* 
* @return true se a lista nao contem elementos
*/
bool ListSingleLinkedPontos::isEmpty()
{
    return count == 0;
}

/**
* Retorna o numero de elementos armazenados na lista.
* 
* @return o numero de elementos da lista
*/
int ListSingleLinkedPontos::size()
{
    return count;
}

/**
* Adiciona um elemento ao final da lista.
* 
* @param element elemento a ser adicionado ao final da lista
*/
void ListSingleLinkedPontos::add(Ponto element)
{
    NodeSingle *n = new NodeSingle(element);
    if (count != 0) // lista já tem elems?
        tail->next = n;
    else
        head = n; // não, este é o primeiro
    tail = n;
    count++;
}

/**
* Adiciona um elemento antes de uma pos. específica
* 
* @param index   posição a inserir o novo elemento
* @param element elemento a ser adicionado
* 
*/
void ListSingleLinkedPontos::add(int index, Ponto element)
{
    if ((index < 0) || (index > count))
    {
        throw "Índice inválido";
    }
    NodeSingle *n = new NodeSingle(element);
    if (index == 0)
    { // inserção no início?
        n->next = head;
        head = n;
    }
    else
    {
        NodeSingle *ant = NULL;
        NodeSingle *target = head;
        for (int pos = 0; pos < index; pos++)
        {
            ant = target;
            target = target->next;
        }
        ant->next = n;
        n->next = target;
    }
    count++;
}

/**
* Retorna o elemento de uma determinada posicao da lista.
* 
* @param index a posicao da lista
* @return o elemento da posicao especificada
* @throws exception se (index < 0 || index >= size())
*/
Ponto ListSingleLinkedPontos::get(int index)
{
    if (index < 0 || index >= count)
    {
        throw "Índice inválido";
    }
    NodeSingle *ptr = head;
    for (int pos = 0; pos < index; pos++)
        ptr = ptr->next;
    return ptr->element;
}

/**
 * Substitui o elemento armazenado em uma determinada posicao da lista pelo
 * elemento passado por parametro, retornando o elemento que foi substituido.
 * @param index a posicao da lista
 * @param element o elemento a ser armazenado na lista
 * @return o elemento armazenado anteriormente na posicao da lista
 * @throws exception se (index < 0 || index >= size())
 */
Ponto ListSingleLinkedPontos::set(int index, Ponto element)
{
    if ((index < 0) || (index >= count))
    {
        throw "Índice inválido!";
    }
    NodeSingle *ptr = head;
    for (int pos = 0; pos < index; pos++)
        ptr = ptr->next;
    Ponto temp = ptr->element; // salva o valor armazenado lá...
    ptr->element = element;
    return temp; // ...e retorna ele
}

/**
 * Procura pelo elemento passado por parametro na lista e retorna true se a
 * lista contem este elemento.
 * @param element o elemento a ser procurado
 * @return true se a lista contem o elemento passado por parametro
 */
bool ListSingleLinkedPontos::contains(Ponto element)
{
    return indexOf(element) != -1;
}

/**
 * Procura pelo elemento passado por parametro na lista, remove e retorna true se a
 * lista continha este elemento.
 * @param element o elemento a ser procurado
 * @return true se conseguir remover
 */
bool ListSingleLinkedPontos::remove(Ponto element)
{
    int pos = indexOf(element);
    if (pos == -1)
        return false; // não existe na lista
    removeByIndex(pos);
    return true;
}

/**
 * Remove um elemento da lista pela sua posição
 * lista continha este elemento.
 * @param index a posição do elemento
 * @return o elemento que estava na posição
 */
Ponto ListSingleLinkedPontos::removeByIndex(int index)
{
    if ((index < 0) || (index >= count))
    {
        throw "Índice inválido!";
    }
    // Se for o início, basta avançar o head
    NodeSingle *aux = head;
    if (index == 0)
    {
        head = head->next;
    }
    else
    {
        NodeSingle *prev = head;
        aux = head->next;
        for (int pos = 1; pos < index; pos++)
        {
            prev = aux;
            aux = aux->next;
        }
        // Remove o elemento
        prev->next = aux->next;
        // Se for o final da lista,
        // ajusta o tail
        if (index == count - 1)
            tail = prev;
    }
    count--;
    // Se a lista ficar vazia (count==0),
    // garante que o tail também será NULL
    if (count == 0)
        tail = NULL;
    Ponto valor = aux->element;
    delete aux; // libera a memória ocupada pelo nodo
    return valor;
}

/**
 * Procura pelo elemento passado por parametro na lista e retorna sua posição,
 * se encontrar
 * @param element o elemento a ser procurado
 * @return posição se encontrado, -1 se não encontrado
 */
int ListSingleLinkedPontos::indexOf(Ponto element)
{
    NodeSingle *ptr = head;
    for (int pos = 0; pos < count; pos++)
    {
        if (ptr->element.x == element.x && ptr->element.y == element.y)
            return pos;
        ptr = ptr->next;
    }
    return -1; // não encontrou
}

/**
* Retorna o conteúdo da lista como uma string
* 
* @return uma string com os elementos da lista
*/
string ListSingleLinkedPontos::toString()
{
    ostringstream aux;
    aux << "[ ";
    NodeSingle *ptr = head;
    while (ptr)
    {
        aux << "(" << ptr->element.x << "," << ptr->element.y << ") ";
        ptr = ptr->next;
    }
    aux << "]";
    return aux.str();
}