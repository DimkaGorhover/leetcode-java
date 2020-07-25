package org.gd.leetcode.p0476;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/number-complement/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
@LeetCode(
        name = "Number Complement",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BIT_MANIPULATION
        }
)
class Solution {

    private static int not(int value) {
        return value == 0 ? 1 : 0;
    }

    public int findComplement(int num) {
        if (num == 0) return 1;
        int x = 0, pos = 0;
        while (num > 0) {
            x |= (not(num & 1) << pos);
            num >>= 1;
            pos++;
        }
        return x;
    }
}
