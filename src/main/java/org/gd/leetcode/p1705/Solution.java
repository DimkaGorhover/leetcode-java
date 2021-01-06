package org.gd.leetcode.p1705;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/maximum-number-of-eaten-apples/
 */
@LeetCode(
        name = "Maximum Number of Eaten Apples",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.HEAP,
                LeetCode.Tags.GREEDY
        }
)
interface Solution {

    int eatenApples(int[] apples, int[] days);
}
