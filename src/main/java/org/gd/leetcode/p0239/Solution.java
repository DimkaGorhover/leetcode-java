package org.gd.leetcode.p0239;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * @author Gorkhover D.
 * @since 2018-11-02
 */
class Solution {

    static int max(int[] nums, int fromIndex, int toIndex) {
        int max = nums[fromIndex];
        for (int i = fromIndex + 1; i < toIndex; i++)
            max = Math.max(max, nums[i]);
        return max;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1 || k == 1)
            return nums;
        if (nums.length == k)
            return new int[]{max(nums, 0, k)};
        final int[] ints = new int[nums.length + 1 - k];
        for (int i = 0; i < ints.length; i++)
            ints[i] = max(nums, i, i + k);
        return ints;
    }
}
