package org.gd.leetcode.p0704;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/binary-search/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0278.Solution
 * @see java.util.Arrays#binarySearch(int[], int)
 * @since 2020-08-15
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Binary Search",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BINARY_SEARCH,
                LeetCode.Tags.ARRAY
        }
)
class Solution {

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            final int val = nums[mid = (low + high) >>> 1];
            if (val < target) {
                low = mid + 1;
            } else if (val > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
