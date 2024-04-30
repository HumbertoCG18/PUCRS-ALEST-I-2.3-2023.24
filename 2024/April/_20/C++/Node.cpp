#include <iostream>
#include "Node.h"

using namespace std;

Node::Node(int i) {
    this->item = i;
    this->prev = NULL;
    this->next = NULL;
}

