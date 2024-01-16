package com.serbanscorteanu.pp.lab2.lab2;

public class Exercise1 {
    public static void main(String[] args) {
// 1. Find the maximum and minimum in an array of integers.
        int[] array = new int[]{5, 2, -2, 500, 68, 95, -15, 10000, -535};
        int[] results = findMinMax(array);
        System.out.println("Min: " + results[0]);
        System.out.println("Max: " + results[1]);
    }

    public static int[] findMinMax(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        return new int[]{min, max};
    }
}
