package org.gd.leetcode.p0643;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/
 *
 * @since 2019-09-19
 */
@LeetCode(difficulty = LeetCode.Level.EASY, tags = LeetCode.Tags.ARRAY)
class Solution {

    public double findMaxAverage(int[] nums, int k) {

        double[] sum = new double[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < sum.length; i++)
            sum[i] += sum[i-1] + nums[i];

        double max = sum[k - 1] / k;
        for (int i = k; i < sum.length; i++)
            max = Math.max(max, (sum[i] - sum[i - k]) / k);

        return max;
    }
}
