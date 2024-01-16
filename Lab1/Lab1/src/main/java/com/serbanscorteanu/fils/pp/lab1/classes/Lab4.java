package com.serbanscorteanu.fils.pp.lab1.classes;

import java.util.Random;

public class Lab4 {
    public static void main(String[] args) {
//        int[][] matrix = new int[5][6]; this is an array of arratys
        int[][] matrix = new int[2][3];
        Random rand = new Random();
        int sum = 0;
        int columnSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(6);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
                sum += matrix[i][j];
            }
            System.out.println(sum);
            System.out.println();
        }
        for (int j = 0; j < matrix[0].length; j++) {
            columnSum = 0;
            for (int i = 0; i < matrix.length; i++) {
                columnSum += matrix[i][j];
            }
            System.out.print(columnSum + "\t");
        }

        // try without separate loop


    }
}
