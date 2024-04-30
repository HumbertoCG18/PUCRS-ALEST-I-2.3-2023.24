#ifndef _NODO
#define _NODO

#include "Ponto.h"

// ****************************
class Node
{
public:
  // Atributos
  Ponto item;
  Node *next;
  Node *prev;

  // Métodos
  Node(Ponto i);
};
#endif
