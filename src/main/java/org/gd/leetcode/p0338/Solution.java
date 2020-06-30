package org.gd.leetcode.p0338;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/counting-bits/
 */
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        tags = {
                LeetCode.Tags.BIT_MANIPULATION,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        })
class Solution implements ISolution {

    static int count(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 0b1);
            n = n >> 1;
        }
        return count;
    }

    @Override
    public int[] countBits(int num) {
        if (num < 0)
            throw new IllegalArgumentException();

        int[] countBits = new int[num + 1];
        for (int i = 1; i <= num; i++)
            countBits[i] = count(i);

        return countBits;
    }
}
