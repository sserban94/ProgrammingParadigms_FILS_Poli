package com.serbanscorteanu.pp.lab2.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_ReverseVowelsString {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(reverseVowels(s));

        String s2 = "leetcode";
        System.out.println(reverseVowels(s2));
    }

    public static String reverseVowels(String s) {
        char[] charArray = s.toLowerCase().toCharArray();
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

        List<Integer> vowelIndices = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (vowels.contains(charArray[i])) {
                vowelIndices.add(i);
            }
        }
        for (int i = 0; i < vowelIndices.size() - 1; i++) {
            char aux = charArray[vowelIndices.get(i)];
            charArray[vowelIndices.get(i)] = charArray[vowelIndices.get(i + 1)];
            charArray[vowelIndices.get(i)] = aux;
        }
        return Arrays.toString(charArray);
    }
}
