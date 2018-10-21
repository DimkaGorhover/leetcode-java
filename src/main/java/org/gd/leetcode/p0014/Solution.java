package org.gd.leetcode.p0014;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * @author Gorkhover D.
 * @since 2018-10-21
 */
class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        final String head = strs[0];
        if (strs.length == 1 || head.length() == 0)
            return head;

        int    endIndex = 0;
        String str;

        bigLoop:
        while (endIndex < head.length()) {
            char c = head.charAt(endIndex);
            for (int i = 1; i < strs.length; i++)
                if (endIndex >= (str = strs[i]).length() || str.charAt(endIndex) != c)
                    break bigLoop;
            endIndex++;
        }

        return head.substring(0, endIndex);

    }
}
