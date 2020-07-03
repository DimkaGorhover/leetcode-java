package org.gd.leetcode.p0014;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * @author Gorkhover D.
 * @since 2018-10-21
 */
@LeetCode(
        name = "Longest Common Prefix",
        state = LeetCode.State.DONE,
        difficulty = LeetCode.Level.EASY,
        tags = LeetCode.Tags.STRING
)
class Solution {

    private static String findPrefix(String str0, String str1) {
        int i0 = 0, l0 = str0.length();
        int i1 = 0, l1 = str1.length();

        for (; i0 < l0 && i1 < l1; i0++, i1++) {
            if (str0.charAt(i0) != str1.charAt(i1))
                break;
        }

        if (i0 == l0) return str0;
        if (i1 == l1) return str1;

        return str0.substring(0, i0);
    }

    public String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0)
            return "";

        String prefix = strings[0];
        if (strings.length == 1 || prefix.isEmpty())
            return prefix;

        for (int i = 1; i < strings.length; i++) {
            prefix = findPrefix(prefix, strings[i]);
            if (prefix.isEmpty())
                return "";
        }

        return prefix;
    }
}
