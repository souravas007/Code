package com.code.leetcode.array.medium;

public class FindTheDuplicateNumber {
    /*
     * Question: https://leetcode.com/problems/find-the-duplicate-number/
     * Learnings: Used linkedlist logic in array problem.
     * Logic:
     * Use two pointer linked list start of loop finder in array.
     * Initially, fast and slow are at 0.
     * Since duplicate exists, it means that there is a loop.
     * When slow reaches the start of the loop (after traveling k distance), fast is at k distance ahead slow.
     * Slow is loop_size - k distance in-front of fast.
     * They meet when slow travels loop_size - k distance from start of loop.
     * From that point, if they travel k distance, they reach the start of the loop.
     * */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = 0;
        do {
            fast = nums[fast];
            slow = nums[slow];
        } while (slow != fast);
        return slow;
    }
}
