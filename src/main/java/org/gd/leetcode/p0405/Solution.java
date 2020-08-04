package org.gd.leetcode.p0405;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-04
 */
@LeetCode(
        name = "Convert a Number to Hexadecimal",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BIT_MANIPULATION
        }
)
interface Solution {

    String toHex(int num);
}
