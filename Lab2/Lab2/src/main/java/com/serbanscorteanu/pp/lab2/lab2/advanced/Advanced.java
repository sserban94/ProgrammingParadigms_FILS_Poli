package com.serbanscorteanu.pp.lab2.lab2.advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Advanced {
    public static void main(String[] args) {
// Create a class Employee with name and other attributes.
// Populate an ArrayList with 10 Employees.
// From the list populate a map.
// Use Scanner to get a name from the keyboard and show the corresponding employee if it exists.
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Serban", 1994, Gender.MALE));
        employees.add(new Employee("Mihnea", 1994, Gender.MALE));
        employees.add(new Employee("Claudiu", 1993, Gender.MALE));
        employees.add(new Employee("Andrei", 1995, Gender.MALE));
        employees.add(new Employee("Stephanie", 1994, Gender.FEMALE));
        employees.add(new Employee("Diana", 1996, Gender.FEMALE));
        employees.add(new Employee("Maria", 2002, Gender.FEMALE));
        employees.add(new Employee("Corina", 1995, Gender.FEMALE));
        employees.add(new Employee("Alexandru", 2003, Gender.MALE));
        employees.add(new Employee("Adriana", 2000, Gender.FEMALE));

        HashMap<String, Employee> employeeHashMap = new HashMap<>();
        for (Employee e : employees) {
            employeeHashMap.put(e.getName(), e);
        }

        String name = getUserInput();
        Employee emp = getEmployeeIfExists(employeeHashMap, name);
        if (emp != null) {
            System.out.println("Employee found");
            System.out.println(emp.getName());
            System.out.println(emp.getYearOfBirth());
            System.out.println(emp.getGender());
        } else {
            System.out.println("Employee not found");
        }


    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input employee name: ");
        return scanner.nextLine();
    }

    public static Employee getEmployeeIfExists(HashMap<String, Employee> employeeHashMap, String inputName) {
        if (employeeHashMap.containsKey(inputName)) {
            return employeeHashMap.get(inputName);
        } else {
            return null;
        }
    }

}
