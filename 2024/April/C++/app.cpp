#include <iostream>
#include "listarray.h"

using namespace std;

// ******************************************
//  Programa principal
// ******************************************
int main()
{
    ListArray lista;

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

    // Invertendo a lista
    cout << endl;
    lista.reverse();
    cout << lista.toString() << endl
         << endl;

    cout << "Testando inserção em ordem crescente..." << endl;
    ListArray lista2;
    for (int i = 1; i < 20; i += 4)
        lista2.addIncreasingOrder(i);
    cout << endl;
    cout << lista2.toString() << endl;
    lista2.addIncreasingOrder(11);
    lista2.addIncreasingOrder(30);
    cout << lista2.toString() << endl
         << endl;

    cout << "Testando inserção em ordem decrescente..." << endl;
    ListArray lista3;
    for (int i = 20; i >= 1; i -= 4)
        lista3.addDecreasingOrder(i);
    cout << endl;
    cout << lista3.toString() << endl;
    lista3.addDecreasingOrder(11);
    lista3.addDecreasingOrder(30);
    cout << lista3.toString() << endl;

    // acrescente código para testar cada um dos novos 
    // métodos implementados, exceto o exercício HighScores 
    // que tem uma classe de teste específica
}
