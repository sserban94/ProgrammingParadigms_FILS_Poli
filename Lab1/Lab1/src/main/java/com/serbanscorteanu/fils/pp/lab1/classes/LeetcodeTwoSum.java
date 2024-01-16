package com.serbanscorteanu.fils.pp.lab1.classes;

import java.util.Arrays;
import java.util.HashMap;

public class LeetcodeTwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSumSlow(nums, target)));
        System.out.println(Arrays.toString(twoSumFaster(nums, target)));
        System.out.println(Arrays.toString(twoSumFastest(nums, target)));
    }

    public static int[] twoSumSlow(int[] nums, int target) {
        // This is the solution with O(n^2) as it uses an inner for loop and checks all
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSumFaster(int[] nums, int target) {
//      Time complexity -> O(2n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            // forgot on the first try - check if the complement is the current elem
            if (map.containsKey(difference) && map.get(difference) != i) {
                return new int[]{i, map.get(difference)};
            }
        }
        return new int[]{};
    }

    public static int[] twoSumFastest(int[] nums, int target) {
        //      Time complexity -> O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[]{map.get(difference), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }




}
