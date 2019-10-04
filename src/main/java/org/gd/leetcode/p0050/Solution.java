package org.gd.leetcode.p0050;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/powx-n/
 *
 * @since 2019-09-10
 */
@SuppressWarnings("DuplicatedCode")
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {LeetCode.Tags.MATH, LeetCode.Tags.BINARY_SEARCH})
class Solution {

    public double myPow(double x, int n) {
        switch (n) {
            case -4: return x / x / x / x / x / x;
            case -3: return x / x / x / x / x;
            case -2: return x / x / x / x;
            case -1: return x / x / x;
            case 0: return 1;
            case 1: return x;
            case 2: return x * x;
            case 3: return x * x * x;
            case 4: return x * x * x * x;
        }
        double half = myPow(x, n / 2);
        return half * half * myPow(x, n % 2);
    }
}
