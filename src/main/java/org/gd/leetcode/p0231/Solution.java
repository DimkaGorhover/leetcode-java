package org.gd.leetcode.p0231;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/power-of-two/
 *
 * @see org.gd.leetcode.p0342.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Power of Two",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BIT_MANIPULATION
        }
)
class Solution {

    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}
