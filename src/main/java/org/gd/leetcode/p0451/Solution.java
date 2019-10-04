package org.gd.leetcode.p0451;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

/**
 * FIXME: https://leetcode.com/problems/sort-characters-by-frequency/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {LeetCode.Tags.HASH_TABLE, LeetCode.Tags.HEAP})
class Solution {

    public String frequencySort(String s) {

        final int         l      = s.length();
        final int[]       counts = new int[128];
        final Character[] chars0 = new Character[l];
        final char[]      chars1 = new char[l];

        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            counts[c]++;
            chars0[i] = c;
        }

        Arrays.sort(chars0, 0, chars0.length, (o1, o2) -> {
            final int compare = counts[o2] - counts[o1];
            return compare != 0 ? compare : o1 - o2;
        });

        for (int i = 0; i < chars0.length; i++)
            chars1[i] = chars0[i];

        return new String(chars1);
    }
}
