#include <iostream>
#include "ListSingleLinked.h"

using namespace std;

// ******************************************
//  Programa principal
// ******************************************
int main()
{
    ListSingleLinked lista;

    lista.add(2);
    lista.add(4);
    lista.add(6);
    lista.add(8);
    lista.add(10);

    lista.add(0, 1);

    cout << lista.toString() << endl;

    cout << "Elemento armazenado na primeira posicao da lista: " << lista.get(0) << endl;
    cout << "Elemento armazenado na ultima posicao da lista: " << lista.get(lista.size() - 1) << endl;
    cout << "Posição do 8: " << lista.indexOf(8) << endl;

    bool ok = lista.remove(6);
    cout << endl;
    if (ok)
        cout << "OK! Consegui remover!" << endl;
    else
        cout << "Elemento não existe" << endl;
    cout << lista.toString();
}
