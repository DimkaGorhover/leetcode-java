package org.gd.leetcode.p0080;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * @since 2020-10-08
 */
@LeetCode(
        name = "Remove Duplicates from Sorted Array II",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.TWO_POINTERS
        }
)
class Solution {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }
}
