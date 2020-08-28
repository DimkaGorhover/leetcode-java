package org.gd.leetcode.p0728;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/self-dividing-numbers/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-28
 */
@LeetCode(
        name = "Self Dividing Numbers",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.MATH
)
class Solution {

    private static boolean isSelfDivided(final int value) {
        if (value == 0) return false;
        if (value < 10) return true;

        for (int div = value, mod; div > 0; div /= 10)
            if ((mod = div % 10) == 0 || (value % mod) != 0)
                return false;

        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> result = new ArrayList<>(right - left + 1);

        for (int i = left; i <= right; i++)
            if (isSelfDivided(i))
                result.add(i);

        return result;
    }
}
