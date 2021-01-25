package org.gd.leetcode.p0169;

/**
 * @see Solution
 * @since 2021-01-23
 */
class BoyerMooreVotingSolution implements Solution {

    @Override
    public int majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums");
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        
        return candidate;
    }
}
