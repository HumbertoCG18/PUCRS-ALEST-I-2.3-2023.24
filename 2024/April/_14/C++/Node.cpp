#include <iostream>
#include "Node.h"

using namespace std;

Node::Node(int i) {
    this->element = i;
    this->next = NULL;
}

Node::Node(int i, Node *next)
{
    this->element = i;
    this->next = next;
}
