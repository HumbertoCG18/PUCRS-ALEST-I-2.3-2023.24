#include <iostream>
#include "Node.h"

using namespace std;

Node::Node(Ponto i) {
    this->item = i;
    this->prev = NULL;
    this->next = NULL;
}

