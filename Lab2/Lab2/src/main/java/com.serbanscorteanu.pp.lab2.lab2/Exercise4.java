package com.serbanscorteanu.pp.lab2.lab2;

public class Exercise4 {
    public static void main(String[] args) {
// 4. Given an n*m integer matrix, if an element is 0, set its entire row and column to 0s
//        int n = 3;
//        int m = 3;
//        int[][] matrix = new int[n][m];
        int[][] matrix = {{1, 2, 3}, {4, 0, -2}, {10, 20, 30}};
        int[][] matrix2 = {{1, 2, 3, 99}, {4, 0, -2}, {10, 20, 30, 40}};
        printMatrix(matrix);
        System.out.println();
        System.out.println();
        printMatrix(matrix2);

        System.out.println("---------------------------------");
        checkMatrixForZero(matrix);
        checkMatrixForZero(matrix2);
        printMatrix(matrix);
        System.out.println();
        printMatrix(matrix2);
    }

    public static void checkMatrixForZero(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
//                    This solution only works for matrices with only one elem with value 0
                    changeRowsColumns(i, j, matrix);
                    return;
                }
            }
            System.out.println();
        }
    }

    private static void changeRowsColumns(int row, int column, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
        for (int j = 0; j < matrix[row].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }


}
