package com.serbanscorteanu.pp.lab6.problemset1.stacks;

import com.serbanscorteanu.pp.lab6.problemset1.entities.Person;

import java.time.LocalDateTime;
import java.time.Month;

public class StackDemo {
    public static void main(String[] args) {
        // Will use string concatenation everywhere even though it's necessarily not the most efficient
        // Also no DRY / Clean code - close deadline
        printStringStack();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        printPersonStack();
    }

    public static void printStringStack() {

        MyStack<String> stringStack = new MyStack<>();
        // added number prefix for better readability
        stringStack.push("1.PP");
        stringStack.push("2.BD");
        stringStack.push("3.GISS");
        stringStack.push("4.AC");
        stringStack.push("5.FM");
        System.out.println("-----------------------------STRING STACK-----------------------------------");
        // another old habit - learned at some point that  new line/line feed varies from os to os
        // lineSep is OS-agnostic / device-agnostic
        System.out.println("Original Stack - printed reversed via recursion" + System.lineSeparator());
        stringStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack peek method:" + System.lineSeparator());
        System.out.println("Node peaked at: " + stringStack.peek() + System.lineSeparator());
        System.out.println("Stack should be intact" + System.lineSeparator());
        stringStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack pop method:" + System.lineSeparator());
        System.out.println("Node popped: " + stringStack.pop() + System.lineSeparator());
        System.out.println("Stack should have one less element - the last one" + System.lineSeparator());
        stringStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack push method:" + System.lineSeparator());
        String newString = "5.Research Paper - State of Art";
        stringStack.push(newString);
        System.out.println("Val pushed: " + newString + System.lineSeparator());
        System.out.println("Stack should have one new element - hopefully on the last pos" + System.lineSeparator());
        stringStack.print();
    }

    public static void printPersonStack() {

        MyStack<Person> personStack = new MyStack<>();
        // added number prefix for better readability
        personStack.push(
                new Person(
                        "1.Serban",
                        "Scorteanu",
                        LocalDateTime.of(1900, Month.JANUARY, 1, 0, 0)));
        personStack.push(
                new Person(
                        "2.Serban",
                        "Scorteanu",
                        LocalDateTime.of(1900, Month.JANUARY, 1, 0, 0)));
        personStack.push(
                new Person(
                        "3.Serban",
                        "Scorteanu",
                        LocalDateTime.of(1900, Month.JANUARY, 1, 0, 0)));
        personStack.push(
                new Person(
                        "4.Serban",
                        "Scorteanu",
                        LocalDateTime.of(1900, Month.JANUARY, 1, 0, 0)));
        personStack.push(
                new Person(
                        "5.Serban",
                        "Scorteanu",
                        LocalDateTime.of(1900, Month.JANUARY, 1, 0, 0)));
        System.out.println("------------------------------PERSON STACK----------------------------------");
        // another old habit - learned at some point that  new line/line feed varies from os to os
        // lineSep is OS-agnostic / device-agnostic
        System.out.println("Original Stack - printed reversed via recursion" + System.lineSeparator());
        personStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack peek method:" + System.lineSeparator());
        System.out.println("Node peaked at: " + personStack.peek() + System.lineSeparator());
        System.out.println("Stack should be intact" + System.lineSeparator());
        personStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack pop method:" + System.lineSeparator());
        Person poppedPerson = personStack.pop();
        System.out.println("Node popped: " + poppedPerson + System.lineSeparator());
        System.out.println("Stack should have one less element - the last one" + System.lineSeparator());
        personStack.print();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Stack push method:" + System.lineSeparator());
        personStack.push(poppedPerson);
        System.out.println("Val pushed - previous popped person: " + poppedPerson + System.lineSeparator());
        System.out.println("Stack should have one new element - hopefully on the last pos" + System.lineSeparator());
        personStack.print();
    }

}
