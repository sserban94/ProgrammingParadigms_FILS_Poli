package com.serbanscorteanu.digitalstack;

import java.util.Arrays;

public class TechTest {
    public static void main(String[] args) {
        int[] a = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16};
        int n = a.length;
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length / 2; i++) {
            int aux = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = aux;
        }
        System.out.println(Arrays.toString(a));
    }


    public static boolean disjointArrays(int[] groupA, int[] groupB, int[] groupC) {
        for (int a : groupA) {
            for (int b : groupB) {
                for (int c : groupC)
                    if (a == b && b == c) {
                        return false;
                    }
            }
        }
        return true;
    }
}
