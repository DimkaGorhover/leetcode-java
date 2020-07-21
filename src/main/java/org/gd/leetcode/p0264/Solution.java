package org.gd.leetcode.p0264;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 *
 * @see org.gd.leetcode.p0263.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Ugly Number II",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.MATH,
                LeetCode.Tags.DYNAMIC_PROGRAMMING,
                LeetCode.Tags.HEAP
        }
)
interface Solution {

    int nthUglyNumber(int n);
}
