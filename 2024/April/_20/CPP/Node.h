#ifndef _NODO
#define _NODO

// ****************************
class Node
{
public:
  // Atributos
  int item;
  Node *next;
  Node *prev;

  // Métodos
  Node(int i);
};
#endif
