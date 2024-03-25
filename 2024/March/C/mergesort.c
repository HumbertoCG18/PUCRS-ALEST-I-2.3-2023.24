#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX 10000

int arr[MAX];

void sort(int data[], int total);
void mergesort2(int data[], int start, int end);
void merge(int data[], int start, int mid, int end);

void sort(int data[], int total) {
    mergesort2(data, 0, total-1);
}

void mergesort2(int data[], int start, int end) {
    if (start < end) {
        int mid = (start + end) / 2;
        mergesort2(data, start, mid);
        mergesort2(data, mid + 1, end);
        merge(data, start, mid, end);
    }
}

void merge(int data[], int start, int mid, int end) {
    int p = start, q = mid+1;
    int k=0;
    for(int i=start; i<= end; i++) {
        if(p > mid)
            arr[k++] = data[q++];
        else if(q > end)
            arr[k++] = data[p++];
        else if(data[p] < data[q])
            arr[k++] = data[p++];
        else
            arr[k++] = data[q++];
    }
    for(p=0; p<k; p++)
        data[start++] = arr[p];
}

int main()
{
    int data[MAX];
    for(int i=0; i<MAX; i++)
        data[i] = rand()%(MAX*10);
    long start = clock();
    sort(data, MAX);
    long end = clock();
    //for(int i=0; i<MAX; i++)
    //    printf("%d ", data[i]);
    //printf("\n");
    printf("Tempo para %d elementos: %ld ns\n", MAX,(end-start));
}
