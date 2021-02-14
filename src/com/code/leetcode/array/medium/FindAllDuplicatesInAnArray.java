package com.code.leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    /*
     * Question: https://leetcode.com/problems/find-all-duplicates-in-an-array
     * Learnings: Negate the array to save space and mark visited.
     * Be careful about array index (size-1 is the maximum index).
     * */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                result.add(Math.abs(num));
            }
            nums[Math.abs(num) - 1] *= -1;
        }
        return result;
    }
}
