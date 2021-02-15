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
    public List<Integer> spiralOrder(int[][] matrix) {
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
}