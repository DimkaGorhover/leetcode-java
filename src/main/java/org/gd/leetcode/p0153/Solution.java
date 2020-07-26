package org.gd.leetcode.p0153;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-26
 */
@LeetCode(
        name = "Find Minimum in Rotated Sorted Array",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BINARY_SEARCH
        }
)
class Solution {

    private int[] nums;

    private static int mid(int left, int right) {
        return (left + right + 1) >> 1;
    }

    private int findMin(int leftIndex, int rightIndex) {

        while (true) {

            if (leftIndex == rightIndex)
                return nums[leftIndex];

            if (rightIndex - leftIndex == 1)
                return Math.min(nums[leftIndex], nums[rightIndex]);

            int midIndex = mid(leftIndex, rightIndex);
            int midValue = nums[midIndex];
            int leftValue = nums[leftIndex];

            if (midValue == leftValue) {
                return Math.min(
                        findMin(leftIndex, midIndex),
                        findMin(midIndex, rightIndex));
            }

            if (midValue < leftIndex) {
                rightIndex = midIndex;
            } else {
                leftIndex = midIndex;
            }
        }
    }

    public int findMin(int[] nums) {
        if (nums == null) throw new NullPointerException();
        if (nums.length == 0) throw new IllegalArgumentException();

        switch (nums.length) {
            case 1: return nums[0];
            case 2: return Math.min(nums[0], nums[1]);
        }

        this.nums = nums;

        return findMin(0, nums.length - 1);
    }
}
