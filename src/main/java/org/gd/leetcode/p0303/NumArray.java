package org.gd.leetcode.p0303;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 *
 * @see org.gd.leetcode.p0304.NumMatrix
 * @see org.gd.leetcode.p0307.NumArray
 * @since 2019-09-13
 */
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.EASY, tags = {LeetCode.Tags.DYNAMIC_PROGRAMMING})
class NumArray {

    private final Solution solution;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            solution = new EmptySolution();
        } else {
            solution = new DynamicProgrammingSolution(nums);
        }
    }

    public int sumRange(int i, int j) { return solution.sumRange(i, j); }

    interface Solution {

        int sumRange(int i, int j);
    }

    static class EmptySolution implements Solution {

        @Override
        public int sumRange(int i, int j) { return 0; }
    }

    static class LinearSolution implements Solution {

        private final int[] nums;

        LinearSolution(int[] nums) {
            this.nums = nums;
        }

        @Override
        public int sumRange(int i, int j) {
            if (i > j)
                return 0;

            long sum = 0;
            while (i < j)
                sum += nums[i++];

            return Math.toIntExact(sum);
        }
    }

    static class DynamicProgrammingSolution implements Solution {

        private final int[] sums;

        DynamicProgrammingSolution(int[] nums) {
            sums = Arrays.copyOf(nums, nums.length);
            for (int i = 1; i < nums.length; i++)
                sums[i] += sums[i - 1];
        }

        @Override
        public int sumRange(int i, int j) {
            if (i > j)
                return 0;
            return sums[j] - (i == 0 ? 0 : sums[i - 1]);
        }
    }
}
