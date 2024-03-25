#include <stdio.h>
#include <stdlib.h>

int main()
{
    srand(time(0));
    int vet[10000];
    for(int n=10; n<10000; n++) {
        for(int i=0; i<n; i++)
            vet[i] = rand() % (n*10);
        // Faz alguma coisa com o vetor
        //for(int i=0; i<n; i++)
        //    printf("%d ", vet[i]);
        //printf("\n");        
    }
    return 0;
}