package org.gd.leetcode.p0034;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author Gorkhover D.
 * @see java.util.Arrays#binarySearch0(int[], int, int, int)
 * @since 2018-10-20
 */
class Solution {

    private static final int[]
            NOT_FOUND = new int[]{-1, -1},
            FIRST_POS = new int[]{0, 0};

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target)
            return NOT_FOUND;
        if (nums.length == 1)
            return nums[0] == target ? FIRST_POS : NOT_FOUND;

        int low = 0, high = nums.length - 1, mid, midVal;
        while (low <= high) {
            midVal = nums[mid = (low + high) >>> 1];
            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                int[] res = new int[]{low = mid, high = mid};
                while (0 <= --low && nums[low] == target) res[0] = low;
                while (++high < nums.length && nums[high] == target) res[1] = high;
                return res;
            }
        }
        return NOT_FOUND;
    }
}
