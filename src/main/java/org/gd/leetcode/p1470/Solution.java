package org.gd.leetcode.p1470;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/shuffle-the-array/
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = LeetCode.Tags.ARRAY
)
class Solution {

    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[n << 1];
        for (int i = 0, j = n, z = 0; i < n; i++, j++, z = i << 1) {
            arr[z] = nums[i];
            arr[z + 1] = nums[j];
        }
        return arr;
    }
}
