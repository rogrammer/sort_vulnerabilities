/*
19050111022, FURKAN DEMİR
20050111011, İBRAHİM BAHÇA
20050111034, MERTER ÇOBAN
20050111008, SELÇUK GENÇAY
21050141038, YOUSIF HARITH SUHAIL SUHAIL
 */

package com.github.rhyrak.sorter;

public class QuickSort<T extends Comparable<T>> implements Sorter<T> {
    @Override
    public void sort(T[] entries) {
        quickSort(entries, 0, entries.length - 1); //Starting the quick-sort 
    }

    //Implementing the quick-sort algorithm
    private void quickSort(T[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right); //Get the correct position of the pivot element

            quickSort(arr, left, pivotIndex - 1); //Recursively sorting the left subarray
            quickSort(arr, pivotIndex + 1, right); //Recursively sorting the right subarray
        }
    }

    //Choosing the pivot element and arrange elements smaller than pivot on the left and greater on the right
    private int partition(T[] arr, int left, int right) {
        T pivot = arr[right]; // Choose the pivot element
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j); //Swapping elements to arrange them around the pivot
            }
        }
        swap(arr, i + 1, right); 

        return i + 1;
    }

    //Swapping two elements in the array
    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
