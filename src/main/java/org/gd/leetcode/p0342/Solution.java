package org.gd.leetcode.p0342;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/power-of-four/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0231.Solution
 * @since 2020-08-04
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Power of Four",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BIT_MANIPULATION
        }
)
class Solution {

    private static boolean isPowerOfTwo(int num) {
        return (num > 0) && ((num & (num - 1)) == 0);
    }

    public boolean isPowerOfFour(int num) {
        return isPowerOfTwo(num) && ((num & 0x55555555) != 0);
    }
}
