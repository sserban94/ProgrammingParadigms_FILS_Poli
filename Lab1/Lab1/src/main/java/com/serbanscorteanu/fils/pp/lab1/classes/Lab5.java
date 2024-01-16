package com.serbanscorteanu.fils.pp.lab1.classes;

public class Lab5 {
    public static void main(String[] args) {
        int[] nums = {0, 2, 4, 6, 7, 9, 11, 4, 10, 20, 2, 6, 8, 9, 7, 5, 2};
        int longestSuccessionLength = getLongestSuccessionLength(nums);
        System.out.println("Longest sequence: " + longestSuccessionLength);

        int greatestDifference = getGreatestDifference(nums);
        System.out.println("Greatest difference: " + greatestDifference);
    }

    public static int getLongestSuccessionLength(int[] numArray) {
        int max = 0;
        for (int i = 0; i < numArray.length - 1; i++) {
            if (numArray[i] % 2 == 0) {
                int tempMax = 1;
                for (int j = i + 1; j < numArray.length; j++) {
                    if (numArray[j] % 2 != 0) {
                        break;
                    }
                    tempMax += 1;
                    if (tempMax > max) {
                        max = tempMax;
                    }
                }
            }
        }
        return max;
    }

    public static int getGreatestDifference(int[] nums) {
        int maxDifference = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            int maxTempDifference = nums[i] - nums[j];
            if (maxTempDifference < 0) {
                maxTempDifference = maxTempDifference * -1;
            }
            if (maxTempDifference > maxDifference) {
                maxDifference = maxTempDifference;
            }
        }
        return maxDifference;
    }
}
