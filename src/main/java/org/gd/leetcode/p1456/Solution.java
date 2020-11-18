package org.gd.leetcode.p1456;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 *
 * @author Horkhover Dmytro
 * @since 2020-11-18
 */
@LeetCode(
        name = "Maximum Number of Vowels in a Substring of Given Length",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.STRING,
                LeetCode.Tags.SLIDING_WINDOW
        }
)
class Solution {

    private static final int[] TABLE = {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};

    public int maxVowels(String s, int k) {

        final int length;
        if (s == null || (length = s.length()) < k)
            return 0;

        int i = 0, j = 0, sum = 0;
        while (j < k && j < length) {
            char c = s.charAt(j);
            sum += TABLE[c - 'a'];
            j++;
        }

        int max = sum;
        while (j < length) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            sum += TABLE[c2 - 'a'] - TABLE[c1 - 'a'];
            max = Math.max(max, sum);
            j++;
            i++;
        }

        return max;
    }
}
