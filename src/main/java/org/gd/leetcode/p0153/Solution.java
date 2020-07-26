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

            if (leftIndex == rightIndex || nums[leftIndex] < nums[rightIndex])
                return nums[leftIndex];

            if (rightIndex - leftIndex == 1)
                return Math.min(nums[leftIndex], nums[rightIndex]);

            final int midIndex = mid(leftIndex, rightIndex);

            if (nums[midIndex] == nums[leftIndex]) {
                int leftMin = findMin(leftIndex, midIndex);
                int rightMin = findMin(midIndex, rightIndex);
                return Math.min(leftMin, rightMin);
            }

            if (nums[midIndex] < nums[leftIndex]) {
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
            case 3: return Math.min(nums[0], Math.min(nums[2], nums[1]));
            case 4: return Math.min(Math.min(nums[0], nums[1]), Math.min(nums[2], nums[3]));
        }

        this.nums = nums;

        return findMin(0, nums.length - 1);
    }
}
