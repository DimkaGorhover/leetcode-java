package org.gd.leetcode.p0326;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/power-of-three/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-26
 */
@LeetCode(difficulty = LeetCode.Level.EASY)
class Solution {

    public boolean isPowerOfThree(int n) {
        final double pow = Math.exp(Math.log(n) / 3);
        return Double.compare(pow, Math.round(pow)) == 0;
    }
}
