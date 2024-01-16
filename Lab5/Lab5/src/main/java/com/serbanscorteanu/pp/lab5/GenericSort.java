package com.serbanscorteanu.pp.lab5;

public class GenericSort {
    //    TODO - how to restrict this to numbers only
    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                int j = i + 1;
                if (arr[i].compareTo(arr[j]) > 0) {
                    isSorted = false;
                    swap(j, i, arr);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void swap(int index1, int index2, T[] arr) {
        T aux = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = aux;
    }

}
