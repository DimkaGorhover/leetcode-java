package org.gd.leetcode.p0283;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * @since 2019-09-13
 */
@LeetCode(difficulty = LeetCode.Level.EASY, tags = {LeetCode.Tags.ARRAY, LeetCode.Tags.TWO_POINTERS})
class Solution {

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
                j++;
            }
        }
    }
}
