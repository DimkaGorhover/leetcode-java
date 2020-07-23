package org.gd.leetcode.p0693;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/binary-number-with-alternating-bits/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0191.Solution
 * @see org.gd.leetcode.p0461.Solution
 * @see org.gd.leetcode.p0477.Solution
 * @since 2020-07-09
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Binary Number with Alternating Bits",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.BIT_MANIPULATION
)
class Solution {

    public boolean hasAlternatingBits(int n) {
        int prev = n & 1, next;
        while ((n >>= 1) > 0) {
            if (prev == (next = n & 1))
                return false;
            prev = next;
        }
        return true;
    }
}
