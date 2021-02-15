package com.code.leetcode.array.medium;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                fillMatrixRow(i, matrix);
            }
        }
        for (int j = 0; j < col.length; j++) {
            if (col[j] == 1) {
                fillMatrixCol(j, matrix);
            }
        }
    }

    private void fillMatrixRow(int i, int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] = 0;
        }
    }

    private void fillMatrixCol(int j, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }
}