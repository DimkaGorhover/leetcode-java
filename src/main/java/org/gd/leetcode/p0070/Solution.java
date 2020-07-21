package org.gd.leetcode.p0070;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
@Repeat("DYNAMIC_PROGRAMMING")
@LeetCode(
        name = "Climbing Stairs",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
interface Solution {

    int climbStairs(int n);
}
