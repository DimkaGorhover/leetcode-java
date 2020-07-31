package org.gd.leetcode.p0724;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/find-pivot-index/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
@LeetCode(
        name = "Find Pivot Index",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY
        }
)
class Solution {

    private static int onlyPositiveNumbersPivotIndex(int[] nums, int rightSum) {
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum)
                return i;
            if (leftSum > rightSum)
                return -1;
            leftSum += nums[i];
        }
        return -1;
    }

    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        boolean onlyPositive = true;
        for (int num : nums) {
            rightSum += num;
            if (num < 0) onlyPositive = false;
        }

        if (onlyPositive)
            return onlyPositiveNumbersPivotIndex(nums, rightSum);

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }

        return -1;
    }
}
