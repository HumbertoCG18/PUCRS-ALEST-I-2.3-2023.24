#ifndef _NODO
#define _NODO

// ****************************
class Node {
public:
  // Atributos
  int element;
  Node *next;
  Node *prev;

  // Métodos
  Node(int i);
};
#endif 
