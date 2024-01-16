package com.serbanscorteanu.pp.lab2.lab2.advanced;

public class Employee {
    private String name;
    private int yearOfBirth;
    private Gender gender;

    public Employee() {
        this.name = "";
        this.yearOfBirth = 0;
        this.gender = Gender.NOT_DECLARED;
    }

    public Employee(String name, int yearOfBirth, Gender gender) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
