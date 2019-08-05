package org.gd.leetcode.p0190;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/reverse-bits/
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = LeetCode.Tags.BIT_MANIPULATION
)
class Solution {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result = result | ((n >>> i) & 1);
        }
        return result;
    }
}
