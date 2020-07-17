package org.gd.leetcode.p0494;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/target-sum/
 *
 * @author Horkhover D.
 * @since 2020-07-17
 */
@LeetCode(
        name = "Target Sum",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DEPTH_FIRST_SEARCH,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class Solution {

    private Integer[][] memo;
    private int target;
    private int[] nums;

    private int find(int sum, int index) {

        if (index == nums.length)
            return sum == target ? 1 : 0;

        if (memo[index][sum + 1000] != null)
            return memo[index][sum + 1000];

        final int num = nums[index];
        int count0 = find(sum + num, index + 1);
        int count1 = find(sum - num, index + 1);

        memo[index][sum + 1000] = count0 + count1;

        return count0 + count1;
    }

    public int findTargetSumWays(int[] nums, int S) {
        this.nums = nums;
        memo = new Integer[nums.length][2002];
        target = S;

        return find(0, 0);
    }
}
