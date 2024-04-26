#include <iostream>
#include "NodeSingle.h"

using namespace std;

NodeSingle::NodeSingle(Ponto i) {
    this->element = i;
    this->next = NULL;
}

NodeSingle::NodeSingle(Ponto i, NodeSingle *next)
{
    this->element = i;
    this->next = next;
}
