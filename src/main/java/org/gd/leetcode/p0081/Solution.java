package org.gd.leetcode.p0081;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0033.Solution
 * @see org.gd.leetcode.p0153.Solution
 * @see org.gd.leetcode.p0154.Solution
 * @see java.util.Arrays#binarySearch(int[], int)
 * @since 2020-07-27
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Search in Rotated Sorted Array II",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BINARY_SEARCH
        }
)
class Solution {

    private int[] nums;
    private int target;

    private boolean search(int left, int right) {
        while (left < right) {

            int mid = (left + right + 1) >>> 1;

            if (nums[mid] == target || nums[left] == target || nums[right] == target)
                return true;

            if (nums[left] == nums[mid])
                return search(left, mid - 1) || search(mid + 1, right);


            if (nums[left] > nums[mid]) {

                if (target < nums[mid] || target > nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {

                if (nums[left] < target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
        }

        return false;
    }

    public boolean search(int[] nums, int target) {

        this.nums = nums;
        this.target = target;

        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1 && nums[0] == target) return true;

        return search(0, nums.length - 1);
    }
}
