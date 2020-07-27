package org.gd.leetcode.p0033;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0153.Solution
 * @see org.gd.leetcode.p0154.Solution
 * @see java.util.Arrays#binarySearch(int[], int)
 * @since 2020-07-27
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Search in Rotated Sorted Array",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BINARY_SEARCH
        }
)
class Solution {

    private static int linearSearch(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] == target)
                return i;

        return -1;
    }

    public int search(int[] nums, int target) {

        if (nums == null)
            return -1;

        if (nums.length < 5)
            return linearSearch(nums, target);

        int left = 0;
        int mid;
        int right = nums.length - 1;

        while (left < right) {

            final int midValue = nums[mid = (left + right) >>> 1];
            final int leftValue = nums[left];
            final int rightValue = nums[right];

            if (midValue == target) return mid;
            if (leftValue == target) return left;
            if (rightValue == target) return right;

            if (leftValue > midValue) {

                if (target < midValue && leftValue > target) {
                    right = mid;
                } else {
                    left = mid;
                }

            } else {

                if (leftValue < target && target < midValue) {
                    right = mid;
                } else {
                    left = mid;
                }

            }

        }

        return -1;
    }
}
