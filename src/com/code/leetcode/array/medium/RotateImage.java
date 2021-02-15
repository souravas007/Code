package com.code.leetcode.array.medium;

public class RotateImage {

	/*
	 * Question: https://leetcode.com/problems/rotate-image/solution/
	 * Logic:
	 * The top row is controlled by i.
	 * The bottom row is controlled by offset (i-layer).
	 * */
	public void rotate( int[][] matrix ) {
		int n = matrix.length;

		for ( int layer = 0; layer < n / 2; layer++ ) {
			int last = n - 1 - layer;
			for ( int i = layer; i < last; i++ ) {
				int offset = i - layer;
				int top = matrix[layer][i];
				matrix[layer][i] = matrix[last - offset][layer];
				matrix[last - offset][layer] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
	}
}