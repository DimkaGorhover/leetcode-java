package org.gd.leetcode.p0202;

import org.gd.leetcode.common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 */
@LeetCode(
        name = "Happy Number",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.MATH
        }
)
class Solution {

    private static int sqr(int value) { return value * value; }

    private static int sumDigitsSquare(int value) {
        int sum = 0;
        while (value > 0) {
            sum += sqr(value % 10);
            value /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            if (set.contains(n = sumDigitsSquare(n)))
                return false;
            set.add(n);
        }
        return true;
    }
}
