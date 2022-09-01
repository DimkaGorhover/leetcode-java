package org.gd.leetcode.p0279;

import org.gd.leetcode.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/perfect-squares/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-22
 */
@Repeat("DYNAMIC_PROGRAMMING")
@LeetCode(
        name = "Perfect Squares",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.MATH,
                LeetCode.Tags.DYNAMIC_PROGRAMMING,
                LeetCode.Tags.BREADTH_FIRST_SEARCH
        })
interface Solution {

    int numSquares(int n);
}
