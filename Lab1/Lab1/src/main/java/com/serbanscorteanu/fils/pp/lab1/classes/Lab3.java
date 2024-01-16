package com.serbanscorteanu.fils.pp.lab1.classes;

import java.util.List;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        System.out.println("Input text and I will tell you the vowel and consonant count in your text");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine().strip();
//        String trimmedSentence = sentence.replaceAll(" ", "");
        List<String> vowelList = List.of("a", "e", "i", "o", "u");
        int noVowels = 0;
        int noNonAlphabetic = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (!Character.isAlphabetic(sentence.charAt(i))){
                noNonAlphabetic += 1;
                continue;
            }
            if (vowelList.contains(String.valueOf(sentence.charAt(i)))) {
                noVowels += 1;
            }
        }
        System.out.println("Number of vowels: " + noVowels);
        System.out.println("Number of consonants: " + (sentence.length() - noVowels - noNonAlphabetic));
    }
}
