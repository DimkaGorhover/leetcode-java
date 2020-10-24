package org.gd.leetcode.p0027;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/remove-element/
 *
 * @author Gorkhover D.
 * @since 2018-10-22
 */
@LeetCode(
        name = "Remove Element",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.LINKED_LIST
)
class Solution {

    public int removeElement(int[] nums, int val) {
        if (nums == null)
            return 0;
        switch (nums.length) {
            case 0: return 0;
            case 1: return nums[0] == val ? 0 : 1;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val)
                nums[j++] = nums[i];
        return j;
    }
}
