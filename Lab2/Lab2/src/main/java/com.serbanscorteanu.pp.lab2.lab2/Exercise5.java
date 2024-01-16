package com.serbanscorteanu.pp.lab2.lab2;

public class Exercise5 {
    public static void main(String[] args) {
//  5. Merge arrays. You are given two arrays of integers, both sorted in increasing order.
//  Return the merged array, its elements should also be in increasing order.

        int[] array1 = new int[]{0, 2, 6, 8};
        int[] array2 = new int[]{1, 3, 4, 7, 8};
        int[] mergedArray = createMergedArray(array1, array2);
        printArray(mergedArray);
        System.out.println();

        int[] array3 = new int[]{-5, -3, 0, 10, 40};
        int[] array4 = new int[]{-4, 5, 12, 18, 20, 25};
        int[] mergedArray2 = createMergedArray(array3, array4);
        printArray(mergedArray2);
        System.out.println();

        int[] array5 = new int[]{1, 2, 2, 2, 7};
        int[] array6 = new int[]{2, 2, 6, 8};
        int[] mergedArray3 = createMergedArray(array5, array6);
        printArray(mergedArray3);
        System.out.println();

        int[] array7 = new int[]{};
        int[] array8 = new int[]{1, 2, 3};
        int[] mergedArray4 = createMergedArray(array7, array8);
        printArray(mergedArray4);
        System.out.println();

        int[] array9 = new int[]{1, 2, 2, 2, 7};
        int[] array10 = new int[]{2, 2, 6, 8};
        int[] mergedArray5 = createMergedArray(array10, array9);
        printArray(mergedArray5);
        System.out.println();
    }

    public static int[] createMergedArray(int[] array1, int[] array2) {
        int[] newArray = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        for (int elem = 0; elem < newArray.length; elem++) {
            if (i < array1.length && (j >= array2.length || array1[i] <= array2[j])) {
                newArray[elem] = array1[i++];
            } else if (j < array2.length) {
                newArray[elem] = array2[j++];
            }
        }
        return newArray;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
