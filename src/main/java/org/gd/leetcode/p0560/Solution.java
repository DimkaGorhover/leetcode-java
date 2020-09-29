package org.gd.leetcode.p0560;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

/**
 * @see org.gd.leetcode.p0713.Solution
 *
 * @author Horkhover Dmytro
 * @since 2020-09-29
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Subarray Sum Equals K",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.HASH_TABLE
        }
)
class Solution {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] table = new int[nums.length + 1];
        table[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            table[i + 1] = table[i] + nums[i];
        }

        System.out.println(Arrays.toString(table));

        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }
}
