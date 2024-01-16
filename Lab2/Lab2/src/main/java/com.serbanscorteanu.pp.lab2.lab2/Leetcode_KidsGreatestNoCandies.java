package com.serbanscorteanu.pp.lab2.lab2;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_KidsGreatestNoCandies {
    public static void main(String[] args) {
        int[] leetcodeTestCaseArray1 = new int[]{2,3,5,1,3};
        int extraCandies1 = 3;
        System.out.println(kidsWithCandies(leetcodeTestCaseArray1, extraCandies1));

        int[] leetcodeTestCaseArray2 = new int[]{4,2,1,1,2};
        int extraCandies2 = 1;
        System.out.println(kidsWithCandies(leetcodeTestCaseArray2, extraCandies2));

        int[] leetcodeTestCaseArray3 = new int[]{12,1,12};
        int extraCandies3 = 10;
        System.out.println(kidsWithCandies(leetcodeTestCaseArray3, extraCandies3));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> couldBeGreatestArray = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

        for (int i = 0; i < candies.length; i++) {
            if ((candies[i] + extraCandies) >= max) {
                couldBeGreatestArray.add(i, true);
            } else {
                couldBeGreatestArray.add(i, false);
            }
        }

        return couldBeGreatestArray;
    }
}
