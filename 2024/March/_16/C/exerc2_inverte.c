#include <stdio.h>

void inverte(int v[], int total);
void inverteRec(int v[], int pos, int total);

void inverte(int v[], int total)
{
    inverteRec(v, 0, total);
}

void inverteRec(int v[], int pos, int total)
{
    if(pos == total/2)
        return;
    int temp = v[pos];
    v[pos] = v[total-pos-1];
    v[total-pos-1] = temp;
    inverteRec(v, pos+1, total);
}

int main()
{
    int vet[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
    for (int i = 0; i < 8; i++)
        printf("%d ", vet[i]);
    printf("\n");
    inverte(vet,8);
    for (int i = 0; i < 8; i++)
        printf("%d ", vet[i]);
    printf("\n");
}
