#ifndef _NODO
#define _NODO

// ****************************
class Node {
public:
  // Atributos
  int element;
  Node *next;

  // Métodos
  Node(int i);
  Node(int i, Node *next);
};
#endif 
