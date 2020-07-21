package org.gd.leetcode.p0509;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/fibonacci-number/
 *
 * @see org.gd.leetcode.p0070.Solution
 * @see org.gd.leetcode.p1137.Solution
 * @since 2019-10-02
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Fibonacci Number",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.MATH,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
interface Solution {

    int fib(int n);
}
