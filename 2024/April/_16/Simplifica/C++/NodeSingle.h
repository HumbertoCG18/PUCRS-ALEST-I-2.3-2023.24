#ifndef _NODO
#define _NODO

#include "Ponto.h"

// ****************************
class NodeSingle {
public:
  // Atributos
  Ponto element;
  NodeSingle *next;

  // Métodos
  NodeSingle(Ponto i);
  NodeSingle(Ponto i, NodeSingle *next);
};
#endif 
