package com.serbanscorteanu.pp.lab2.lab2;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Exercise3 {
    public static void main(String[] args) {
// 3. You are given an array of characters containing letters and brackets such as [ ] { } (    ) .
// Determine whether the brackets are balanced or not
// ( open brackets must be closed by the same type of brackets, in the correct order)
        String text = "[()]{}{[()()]()}";
        String text2 = "[(])";
        char[] charArray = text.toCharArray();
        char[] charArray2 = text2.toCharArray();
        System.out.println("-----------------------QUEUE VERSION--------------------");
        System.out.println("Is char array balanced? - " + isCharArrayBalancedQueueWay(charArray));
        System.out.println("Is char array 2 balanced? - " + isCharArrayBalancedQueueWay(charArray2));

        System.out.println("-----------------------STACK VERSION--------------------");
        System.out.println("Is char array balanced? - " + isCharArrayBalancedStackWay(charArray));
        System.out.println("Is char array 2 balanced? - " + isCharArrayBalancedStackWay(charArray2));
    }

    public static boolean isCharArrayBalancedQueueWay(char[] array) {
        Queue<Character> charQueue = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            if (Character.isAlphabetic(array[i])) {
                continue;
            }
            if (array[i] == '{' || array[i] == '[' || array[i] == '(') {
                charQueue.add(array[i]);
            } else {
                if (charQueue.isEmpty()) {
                    continue;
                }
                switch (array[i]) {
                    case '}':
                        if (charQueue.remove() != '{') {
                            return false;
                        }
                        break;
                    case ']':
                        if (charQueue.remove() != '[') {
                            return false;
                        }
                        break;
                    case ')':
                        if (charQueue.remove() != '(') {
                            return false;
                        }
                        break;
                }
            }
        }
        return charQueue.isEmpty();
    }

    public static boolean isCharArrayBalancedStackWay(char[] array) {
//        Java documentation -> ArrayDeque is faster than Stack
        ArrayDeque<Character> charStack = new ArrayDeque<Character>();
        for (int i = 0; i < array.length; i++) {
            if (Character.isAlphabetic(array[i])) {
                continue;
            }
            if (array[i] == '{' || array[i] == '[' || array[i] == '(') {
                charStack.push(array[i]);
            } else {
                if (charStack.isEmpty()) {
                    continue;
                }
                switch (array[i]) {
                    case '}':
                        if (charStack.pop() != '{') {
                            return false;
                        }
                        break;
                    case ']':
                        if (charStack.pop() != '[') {
                            return false;
                        }
                        break;
                    case ')':
                        if (charStack.pop() != '(') {
                            return false;
                        }
                        break;
                }
            }
        }
        return charStack.isEmpty();
    }
}
