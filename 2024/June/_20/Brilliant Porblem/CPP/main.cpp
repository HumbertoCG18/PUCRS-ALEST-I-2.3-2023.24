#include <iostream>
#include <string>
#include <vector>
#include "BinaryTree.h"

BinaryTree<int> *gera(int height, int val)
{
    BinaryTree<int> *temp = new BinaryTree<int>(val);
    temp->h = height;
    if (height == 0)
    {
        temp->left = nullptr;
        temp->right = nullptr;
    }
    else
    {
        temp->left = gera(height - 1, val * 2);
        temp->right = gera(height - 1, val * 2 + 1);
    }
    return temp;
}

int main()
{
    BinaryTree<int> *root = gera(3, 1);

    for (int bola = 1; bola < 6; bola++)
        cout << "Bola " << bola << ": " << root->traverse(root) << endl;
    root->clear();
}
