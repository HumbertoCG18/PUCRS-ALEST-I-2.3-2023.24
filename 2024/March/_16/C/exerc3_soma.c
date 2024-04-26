#include <stdio.h>

int soma(int v[], int total);
int somaRec(int v[], int pos, int total);

int soma(int v[], int total)
{
    return somaRec(v, 0, total);
}

int somaRec(int v[], int pos, int total)
{
    if (pos == total)
        return 0;
    return v[pos] + somaRec(v, pos+1, total);
}

int main()
{
    int vet[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
    for (int i = 0; i < 8; i++)
        printf("%d ", vet[i]);
    printf("\n");
    printf("Soma: %d\n", soma(vet,8));
}
