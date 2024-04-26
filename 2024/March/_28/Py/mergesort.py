#!/usr/bin/python3
#
# Mergesort
#

import random
from time import process_time

def mergeSort(alist):

    #print("Splitting ",alist)

    if len(alist) > 1:

        mid = len(alist) // 2   # Div. inteira
        lefthalf = alist[:mid]  # slicing: lista até mid-1
        righthalf = alist[mid:] # slicing: lista de mid ao final

        mergeSort(lefthalf)
        mergeSort(righthalf)

        i = 0
        j = 0
        k = 0

        while i < len(lefthalf) and j < len(righthalf):

            if lefthalf[i] < righthalf[j]:
                alist[k] = lefthalf[i]
                i += 1
            else:
                alist[k] = righthalf[j]
                j += 1
            k += 1

        while i < len(lefthalf):
            alist[k] = lefthalf[i]
            i += 1
            k += 1

        while j < len(righthalf):
            alist[k] = righthalf[j]
            j += 1
            k += 1

    #print("Merging ",alist)

#alist = []
#for x in range(1000):
#    alist.append(random.randint(0,10000))

#alist = [54,26,93,17,77,31,44,55,20]

MAX = 10000
data = [random.randint(0,MAX*10) for x in range(MAX)]

start = process_time()
mergeSort(data)
end = process_time()
t = end-start

print(f"Tempo para ordenar {MAX} elementos: {t} s")

