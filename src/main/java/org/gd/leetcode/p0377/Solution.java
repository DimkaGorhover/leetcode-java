package org.gd.leetcode.p0377;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 *
 * @see org.gd.leetcode.p0039.Solution
 * @see org.gd.leetcode.p0040.Solution
 */
@SuppressWarnings({"JavadocReference", "DuplicatedCode"})
@Repeat("fucking dynamic programming")
@LeetCode(
        name = "Combination Sum IV",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.DYNAMIC_PROGRAMMING
)
class Solution {

    private int[] nums;
    private int[] dp;

    private static boolean isSorted(int[] arr) {
        if (arr.length <= 1)
            return true;
        for (int i = 0, j = 1; j < arr.length; i++, j++) {
            final int prev = arr[i];
            if (prev > arr[j]) {
                arr[i] = arr[j];
                arr[j] = prev;
                return false;
            }
        }
        return true;
    }

    public int combinationSum4(int[] nums, int target) {

        this.nums = nums;
        if (!isSorted(nums))
            Arrays.sort(nums);

        dp = new int[target + 1];
        dp[0] = 1;
        Arrays.fill(dp, 1, dp.length, -1);

        return combine(target);
    }

    private int combine(int target) {
        if (dp[target] != -1)
            return dp[target];
        int sum = 0;
        for (int num : nums) {
            if (target < num)
                break;
            sum += combine(target - num);
        }
        return dp[target] = sum;
    }
}
