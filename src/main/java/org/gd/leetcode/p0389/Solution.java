package org.gd.leetcode.p0389;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/find-the-difference/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
@LeetCode(
        name = "Find the Difference",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.BIT_MANIPULATION
        }
)
interface Solution {

    char findTheDifference(String s, String t);
}
