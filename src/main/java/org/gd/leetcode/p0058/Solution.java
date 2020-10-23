package org.gd.leetcode.p0058;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/length-of-last-word/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-19
 */
@LeetCode(
        name = "Length of Last Word",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.STRING)
class Solution {

    public int lengthOfLastWord(String s) {
        int i;
        if (s == null || (i = s.length() - 1) < 0)
            return 0;

        while (i >= 0 && s.charAt(i) == ' ')
            i--;

        int sum = 0;
        while (i >= 0 && s.charAt(i--) != ' ')
            sum++;

        return sum;
    }
}
