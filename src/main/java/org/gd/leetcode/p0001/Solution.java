package org.gd.leetcode.p0001;

public class Solution {

    public int[] twoSum(int[] nums, int target) {

        int l1 = nums.length;
        int l2 = nums.length;

        bigLoop:
        for (int i = 0; i < l1; i++) {
            for (int j = i + 1; j < l2; j++) {
                final int sum = nums[i] + nums[j];
                if (target == sum) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
