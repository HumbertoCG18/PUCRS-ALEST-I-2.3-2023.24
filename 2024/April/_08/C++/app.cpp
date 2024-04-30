#include <iostream>
#include "queuearray.h"

using namespace std;

// ******************************************
//  Programa principal
// ******************************************
int main()
{
    // Cria uma fila
    // QueueTAD fila = new QueueArray();
    QueueArray fila;
    // Insere alguns números
    fila.enqueue(2);
    fila.enqueue(4);
    fila.enqueue(6);
    fila.enqueue(8);
    fila.enqueue(10);
    // Remove e vai mostrando na tela
    // até ficar vazia
    while (!fila.isEmpty())
    {
        cout << fila.toString() << endl;
        cout << fila.dequeue() << endl;
    }
}
