package org.gd.leetcode.p0215;

/**
 * @see HeapSolution
 */
class SortSolution implements Solution {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            throw new NullPointerException("nums cannot be null");
        }

        if (k < 0) {
            throw new IllegalArgumentException("k cannot be less than 0");
        }

        if (k >= nums.length) {
            throw new IllegalArgumentException("k cannot be more than length of array");
        }

        java.util.Arrays.sort(nums);
        return nums[k];
    }
}
