package org.gd.leetcode.p0909;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/snakes-and-ladders/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-10
 */
@LeetCode(
        name = "Snakes and Ladders",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BREADTH_FIRST_SEARCH
        }
)
interface Solution {

    int snakesAndLadders(int[][] board);
}
