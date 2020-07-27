package org.gd.leetcode.p0239;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-28
 */
class DequeSolution implements Solution {

    private static int linearMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++)
            max = Math.max(max, nums[i]);
        return max;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || nums.length == 1 || k == 1)
            return nums;

        if (nums.length == k)
            return new int[]{linearMax(nums)};

        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }
}
