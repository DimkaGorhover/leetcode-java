package org.gd.leetcode.p0162;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/find-peak-element/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-23
 */
@LeetCode(
        name = "Find Peak Element",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BINARY_SEARCH
        }
)
class Solution {

    public int findPeakElement(int[] nums) {

        if (nums == null) throw new NullPointerException();
        if (nums.length == 0) throw new IllegalArgumentException();

        switch (nums.length) {
            case 1: return 0;
            case 2: return nums[0] > nums[1] ? 0 : 1;
        }

        int num;
        int maxIndex = 0;
        int maxValue = nums[maxIndex];
        for (int i = 1; i < nums.length - 1; i++) {

            if (nums[i - 1] < (num = nums[i]) && num > nums[i + 1])
                return i;

            if (num > maxValue) {
                maxValue = num;
                maxIndex = i;
            }
        }

        num = nums[nums.length - 1];
        if (num > maxValue)
            return nums.length - 1;

        return maxIndex;
    }
}
