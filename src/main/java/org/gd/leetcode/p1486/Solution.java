package org.gd.leetcode.p1486;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/xor-operation-in-an-array/
 */
@LeetCode(
        name = "Xor Operation In An Array",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BIT_MANIPULATION
        })
class Solution {

    public int xorOperation(int n, int start) {
        int xor = start;
        for (int i = 1; i < n; i++)
            xor = xor ^ (start + (2 * i));
        return xor;
    }
}
