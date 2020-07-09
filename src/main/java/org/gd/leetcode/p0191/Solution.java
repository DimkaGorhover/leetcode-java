package org.gd.leetcode.p0191;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0461.Solution
 * @see org.gd.leetcode.p0693.Solution
 * @since 2020-07-09
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Number of 1 Bits",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.BIT_MANIPULATION
)
class Solution {

    public int hammingWeight(int n) {
        long l = Integer.toUnsignedLong(n) << 1;
        int count = 0;
        while (l > 0) {
            count += l & 1;
            l >>= 1;
        }
        return count;
    }
}
