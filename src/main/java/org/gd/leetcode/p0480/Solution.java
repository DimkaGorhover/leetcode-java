package org.gd.leetcode.p0480;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sliding-window-median/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-22
 */
@LeetCode(
        name = "Sliding Window Median",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.SLIDING_WINDOW
        }
)
class Solution {

    private static double median(int[] nums) {
        Arrays.sort(nums);
        final int mid = nums.length >> 1;
        if (nums.length % 2 == 0) {
            double num0 = nums[mid];
            double num1 = nums[mid - 1];
            return (num0 + num1) * 0.5;
        }
        return nums[mid];
    }

    public double[] medianSlidingWindow(int[] nums, final int k) {

        if (nums == null) return null;
        if (nums.length == 1) return new double[]{nums[0]};
        if (nums.length == k) return new double[]{median(nums)};

        Result result = new Result(nums.length - k + 1);
        SlidingWindow sw = new SortedList(nums, k);
        result.add(sw.median());
        for (int i = k; i < nums.length; i++) {
            sw.replace(nums[i - k], nums[i]);
            result.add(sw.median());
        }
        return result.array();
    }
}
