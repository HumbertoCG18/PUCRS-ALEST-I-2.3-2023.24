#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX 10000

void quicksort(int data[], int tam);
void _qsort(int data[], int start, int end);
int partition(int data[], int start, int end);
void swap(int data[], int p1, int p2);

void quicksort(int data[], int tam)
{
    _qsort(data, 0, tam-1);
}

void _qsort(int data[], int start, int end) {
    if(start < end) {
        int pivot_pos = partition(data, start, end);
        _qsort(data, start, pivot_pos-1);
        _qsort(data, pivot_pos+1, end);
    }
}

int partition(int data[], int start, int end) {
    int i = start+1;
    int pivot = data[start];
    for(int j=start+1; j<=end; j++) {
        if(data[j] < pivot) {
            swap(data,i,j);
            i++;
        }
    }
    swap(data,start,i-1);
    return i-1;
}

void swap(int data[], int p1, int p2) {
    int tmp = data[p1];
    data[p1] = data[p2];
    data[p2] = tmp;
}

int main()
{
    int data[MAX];

    for(int i=0; i<MAX; i++)
        data[i] = rand()%(MAX*10);

    long start = clock();
    quicksort(data, MAX);
    long end = clock();

    //for(int i=0; i<MAX; i++)
    //    printf("%5d", data[i]);
    //printf("\n");
    printf("Tempo para %d elementos: %ld ns\n", MAX, (end-start));
}
