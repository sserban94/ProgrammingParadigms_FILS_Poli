package com.serbanscorteanu.pp.lab2.lab2;

import java.util.HashMap;
import java.util.HashSet;

public class Exercise6 {
    public static void main(String[] args) {
// 6. Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array.
        int[] array1 = {1, 2, 1, 3};
        int[] array2 = {3, 4, 3, 1, 2};
        int[] array3 = {5, 1, 4, 1, 3, 2};
        System.out.println("Retrieving the duplicate - hash map style: ");
        System.out.println(retrieveIntruderHashmapWay(array1));
        System.out.println(retrieveIntruderHashmapWay(array2));
        System.out.println(retrieveIntruderHashmapWay(array3));
        System.out.println();

        System.out.println("Retrieving the duplicate - hash set style: ");
        System.out.println(retrieveIntruderHashsetWay(array1));
        System.out.println(retrieveIntruderHashsetWay(array2));
        System.out.println(retrieveIntruderHashsetWay(array3));
        System.out.println();

        System.out.println("Retrieving the duplicate - boolean array style: ");
        System.out.println(retrieveIntruderBooleanArrayWay(array1));
        System.out.println(retrieveIntruderBooleanArrayWay(array2));
        System.out.println(retrieveIntruderBooleanArrayWay(array3));

    }

    public static int retrieveIntruderHashmapWay(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                return array[i];
            }
            map.put(array[i], i);
        }
        return 0;
    }

    public static int retrieveIntruderHashsetWay(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                return array[i];
            }
            set.add(array[i]);
        }
        return 0;
    }

    public static int retrieveIntruderBooleanArrayWay(int[] array) {
        // so the values can be from 1 to n
        // and the size is n + 1
        // example: [1, 3, 4, 2, 1] has length 5 so the max val is 4
        // so if the max val is 4 -> boolean array with size n + 1
        // 1 3 4 2 1
        // 0 1 2 3 4
        // f f f f f
        boolean[] booleanArray = new boolean[array.length];

        for (int i = 0; i < array.length; i++) {
            if (booleanArray[array[i]]) {
                return array[i];
            }
            booleanArray[array[i]] = true;
        }
        return 0;
    }
}
