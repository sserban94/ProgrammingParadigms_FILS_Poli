package com.serbanscorteanu.pp.lab6.problemset1.stacks;

import com.serbanscorteanu.pp.lab6.problemset1.entities.Person;

import java.time.LocalDateTime;
import java.time.Month;

public class StackableDemo {
    public static void main(String[] args) {
        // Will use string concatenation everywhere even though it's necessarily not the most efficient
        // Also no DRY / Clean code - close deadline
        printStringStack();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        printPersonStack();
    }

    public static void printStringStack() {
        System.out.println("-----------------------------STRING STACK-----------------------------------");
        MyStackableStack<String> stringStackableStack = new MyStackableStack<>();
        System.out.println("Stack isEmpty method:" + System.lineSeparator());
        System.out.println("Stack should be empty - Is it empty? " + stringStackableStack.isEmpty() + System.lineSeparator());
        System.out.println();
        // added number prefix for better readability
        stringStackableStack.push("1.PP");
        stringStackableStack.push("2.BD");
        stringStackableStack.push("3.GISS");
        stringStackableStack.push("4.AC");
        stringStackableStack.push("5.FM");
        // another old habit - learned at some point that  new line/line feed varies from os to os
        // lineSep is OS-agnostic / device-agnostic
        System.out.println("Original Stack - printed reversed via recursion" + System.lineSeparator());
        stringStackableStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack peek method:" + System.lineSeparator());
        System.out.println("Node peaked at: " + stringStackableStack.peek() + System.lineSeparator());
        System.out.println("Stack should be intact" + System.lineSeparator());
        stringStackableStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack pop method:" + System.lineSeparator());
        System.out.println("Node popped: " + stringStackableStack.pop() + System.lineSeparator());
        System.out.println("Stack should have one less element - the last one" + System.lineSeparator());
        stringStackableStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack push method:" + System.lineSeparator());
        String newString = "5.Research Paper - State of Art";
        stringStackableStack.push(newString);
        System.out.println("Val pushed: " + newString + System.lineSeparator());
        System.out.println("Stack should have one new element - hopefully on the last pos" + System.lineSeparator());
        stringStackableStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack isEmpty method:" + System.lineSeparator());
        System.out.println("Stack should not be empty - Is it empty? " + stringStackableStack.isEmpty() + System.lineSeparator());
    }

    public static void printPersonStack() {
        System.out.println("-----------------------------Person STACK-----------------------------------");
        MyStackableStack<Person> personStackableStack = new MyStackableStack<>();
        System.out.println("Stack isEmpty method:" + System.lineSeparator());
        System.out.println("Stack should be empty - Is it empty? " + personStackableStack.isEmpty() + System.lineSeparator());
        System.out.println();
        // added number prefix for better readability
        personStackableStack.push(
                new Person(
                        "1.Serban",
                        "Scorteanu",
                        LocalDateTime.of(1900, Month.JANUARY, 1, 0, 0)));
        personStackableStack.push(
                new Person(
                        "2.Serban",
                        "Scorteanu",
                        LocalDateTime.of(1900, Month.JANUARY, 1, 0, 0)));
        personStackableStack.push(
                new Person(
                        "3.Serban",
                        "Scorteanu",
                        LocalDateTime.of(1900, Month.JANUARY, 1, 0, 0)));
        personStackableStack.push(
                new Person(
                        "4.Serban",
                        "Scorteanu",
                        LocalDateTime.of(1900, Month.JANUARY, 1, 0, 0)));
        personStackableStack.push(
                new Person(
                        "5.Serban",
                        "Scorteanu",
                        LocalDateTime.of(1900, Month.JANUARY, 1, 0, 0)));
        // another old habit - learned at some point that  new line/line feed varies from os to os
        // lineSep is OS-agnostic / device-agnostic
        System.out.println("Original Stack - printed reversed via recursion" + System.lineSeparator());
        personStackableStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack peek method:" + System.lineSeparator());
        System.out.println("Node peaked at: " + personStackableStack.peek() + System.lineSeparator());
        System.out.println("Stack should be intact" + System.lineSeparator());
        personStackableStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack pop method:" + System.lineSeparator());
        Person poppedPerson = personStackableStack.pop();
        System.out.println("Node popped: " + poppedPerson + System.lineSeparator());
        System.out.println("Stack should have one less element - the last one" + System.lineSeparator());
        personStackableStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack push method:" + System.lineSeparator());
        personStackableStack.push(poppedPerson);
        System.out.println("Val pushed - previous popped person: " + poppedPerson + System.lineSeparator());
        System.out.println("Stack should have one new element - hopefully on the last pos" + System.lineSeparator());
        personStackableStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack isEmpty method:" + System.lineSeparator());
        System.out.println("Stack should not be empty - Is it empty? " + personStackableStack.isEmpty() + System.lineSeparator());
    }
}
