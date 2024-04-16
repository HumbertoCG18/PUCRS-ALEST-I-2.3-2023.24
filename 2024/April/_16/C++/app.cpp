#include <iostream>
#include "ListDoubleLinked.h"

using namespace std;

// ******************************************
//  Programa principal
// ******************************************
int main()
{
    ListDoubleLinked lista;

    lista.add(2);
    lista.add(4);
    lista.add(6);
    lista.add(8);
    lista.add(10);

    // lista.add(0, 1);

    cout << lista.toString() << endl;

    cout << "Posição do elemento 8:" << lista.indexOf(8) << endl;
    cout << "Posição do elemento 22:" << lista.indexOf(22) << endl;
    cout << "Existe o elemento 22? " << lista.contains(22) << endl;

    cout << "Elemento armazenado na primeira posicao da lista: " << lista.get(0) << endl;
    cout << "Elemento armazenado na ultima posicao da lista: " << lista.get(lista.size() - 1) << endl;
    cout << "Posição do 8: " << lista.indexOf(8) << endl;

    cout << "\nAlterando o terceiro elemento para 30" << endl;
    lista.set(2, 30);

    cout << lista.toString() << endl;

    cout << "\nInserindo o 7 na quinta posição" << endl;
    lista.add(4, 7);
    cout << lista.toString() << endl;

    cout << "\nInserindo o 11 na última posição" << endl;
    lista.add(lista.size() - 1, 11);
    cout << lista.toString() << endl;

    int elem = lista.removeByIndex(0);
    cout << endl;
    cout << "Removendo o primeiro" << endl;
    cout << "removido: " << elem << endl;
    cout << lista.toString() << endl;

    cout << endl;
    elem = lista.removeByIndex(4);
    cout << "Removendo o quinto elemento" << endl;
    cout << "removido: " << elem << endl;
    cout << lista.toString() << endl;

    cout << endl;
    elem = lista.removeByIndex(lista.size() - 1);
    cout << "Removendo o último elemento" << endl;
    cout << "removido: " << elem << endl;
    cout << lista.toString() << endl;

    // Descomente para apagar a lista inteira
    /*
    while (!lista.isEmpty())
    {
        lista.removeByIndex(0);
        cout << lista.toString() << endl;
    }
    */

    /*
    bool ok = lista.remove(6);
    cout << endl;
    if (ok)
        cout << "OK! Consegui remover!" << endl;
    else
        cout << "Elemento não existe" << endl;
    cout << lista.toString();
    */
}
