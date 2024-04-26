#include <stdio.h>

int potencia(int x, int y);
int potenciaRec(int x, int y);

int potencia(int x, int y)
{
    int res = 1;
    for (int i = 0; i < y; i++)
        res = res * x;
    return res;
}

int potenciaRec(int x, int y)
{
    if (y == 0)
        return 1;
    return x * potenciaRec(x, y - 1);
}

int main()
{
    for (int i = 0; i <= 20; i++)
        printf("2 na %d: %d\n", i, potencia(2, i));
}