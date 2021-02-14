package com.code.leetcode.array.medium;

public class ProductOfArrayExceptItself {
    /*
     * Question: https://leetcode.com/problems/product-of-array-except-self
     *
     * Learnings: Be careful about loop variable. n+1, n-2, >=0 etc. can cause problems.
     * */
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int[] result = new int[nums.length];

        int product = 1;
        leftProduct[0] = product;
        for (int i = 1; i < nums.length; i++) {
            product = product * nums[i - 1];
            leftProduct[i] = product;
        }
        product = 1;
        rightProduct[nums.length - 1] = product;
        for (int i = nums.length - 2; i >= 0; i--) {
            product = product * nums[i + 1];
            rightProduct[i] = product;
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;
    }
}
