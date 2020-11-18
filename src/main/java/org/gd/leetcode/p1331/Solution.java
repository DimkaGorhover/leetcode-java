package org.gd.leetcode.p1331;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/rank-transform-of-an-array/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p1632.Solution
 * @since 2020-11-18
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Rank Transform of an Array",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.ARRAY
)
interface Solution {

    int[] arrayRankTransform(int[] arr);
}
