package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] array = {2, 5, 1, 7, 8, 10};
        printArray(array);
        System.out.println();
        sort(array);
        printArray(array);
        System.out.println();
        Arrays.sort(array);
        printArray(array);

    }

    public static int[] sort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                int j = i + 1;
                if (arr[i] > arr[j]) {
                    isSorted = false;
                    swap(j, i, arr);
                }
            }
        }
        return arr;
    }

    public static void swap(int index1, int index2, int[] array) {
        int aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;
    }

    public static void printArray(int[] array) {
        for (int elem : array) {
            System.out.print(elem + "\t");
        }
    }

}