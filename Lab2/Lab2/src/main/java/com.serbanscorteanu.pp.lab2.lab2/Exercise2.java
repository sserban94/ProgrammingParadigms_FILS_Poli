package com.serbanscorteanu.pp.lab2.lab2;

public class Exercise2 {
    public static void main(String[] args) {
// 2. Find the sum of even elements in an array of integers.
        int[] array = new int[]{5, 2, -2, 500, 68, 95, -15, 10000, -535};
        System.out.println("Sum of even elements: " + computeSumEvenElements(array));
    }

    public static int computeSumEvenElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sum += array[i];
            }
        }
        return sum;
    }
}
