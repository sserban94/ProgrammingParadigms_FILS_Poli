package com.serbanscorteanu.fils.pp.lab1.classes;

public class Lab1 {
    public static void main(String[] args) {
        double result = calculateNumericExpression();
        System.out.println(result);
    }

    public static double calculateNumericExpression() {
        return ((1 / 2.0 + 3 / 17.0 * 5 / 2.0 + Math.sqrt(1 / 2.0)) * (9 / 2.0 + 3 / 4.0)) /
                (2 / (Math.pow(7.0, 3)) * 1 / (Math.pow(3.0, 3)));
    }
}
