package com.code.leetcode.array.medium;


import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /*
     * Question: https://leetcode.com/problems/spiral-matrix/submissions/
     * Learnings:
     * Use a matrix for seen.
     * Use row & column direction.
     * It's values depend upon the increments required for i and j values for matrix traversal.
     * Check the modulus value.
     * */
    public List<Integer> spiralOrderUsingDirection(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        List<Integer> result = new ArrayList<>();
        int[] rowDirection = new int[]{0, 1, 0, -1};
        int[] colDirection = new int[]{1, 0, -1, 0};
        int direction = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < R * C; i++) {
            result.add(matrix[row][col]);
            seen[row][col] = true;
            int tempRow = row + rowDirection[direction];
            int tempCol = col + colDirection[direction];
            if (0 <= tempRow && tempRow < R && 0 <= tempCol && tempCol < C && !seen[tempRow][tempCol]) {
                row = tempRow;
                col = tempCol;
            } else {
                direction = (direction + 1) % 4;
                row = row + rowDirection[direction];
                col = col + colDirection[direction];
            }
        }
        return result;
    }

    public List<Integer> spiralOrderUsingLayer(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                result.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2; r++) {
                result.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    result.add(matrix[r2][c]);
                }
                for (int r = r2; r > r1; r--) {
                    result.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return result;
    }
}