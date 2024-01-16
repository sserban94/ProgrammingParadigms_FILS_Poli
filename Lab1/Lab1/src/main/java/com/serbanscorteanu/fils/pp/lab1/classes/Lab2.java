package com.serbanscorteanu.fils.pp.lab1.classes;

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        //initialize the connection to the keyboard
        Scanner scan = new Scanner(System.in);
        System.out.println("Input first name: ");
        String firstName = scan.nextLine();
        System.out.println("Input last name: ");
        String lastName = scan.nextLine();
        System.out.println("Input CNP: ");
        String cnP = scan.nextLine();
        System.out.println(cnP);
        StringBuilder sb = new StringBuilder();
        String firstTwoLettersFirstName = firstName.substring(0, 2);
        sb.append(firstTwoLettersFirstName.toLowerCase());
        String lastTwoLettersLastName = lastName.substring(lastName.length() - 2);
        sb.append(lastTwoLettersLastName.toUpperCase());
        System.out.println(sb.toString());
    }
}
