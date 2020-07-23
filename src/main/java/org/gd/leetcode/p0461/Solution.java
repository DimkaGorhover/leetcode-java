package org.gd.leetcode.p0461;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/hamming-distance/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0191.Solution
 * @see org.gd.leetcode.p0477.Solution
 * @see org.gd.leetcode.p0693.Solution
 * @since 2020-07-09
 */
@SuppressWarnings({"JavadocReference", "DuplicatedCode"})
@LeetCode(
        name = "Hamming Distance",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.BIT_MANIPULATION
)
class Solution {

    public int hammingDistance(int x, int y) {
        if (x == y)
            return 0;

        int distance = 0;
        while (x > 0 || y > 0) {
            distance += (x & 1) ^ (y & 1);
            x >>= 1;
            y >>= 1;
        }
        return distance;
    }
}
