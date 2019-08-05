package org.gd.leetcode.p0151;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * TODO: replace by linear search on char array
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = LeetCode.Tags.STRING
)
class Solution {

    public String reverseWords(String s) {
        if (s == null || (s = s.trim()).isEmpty())
            return "";
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder(s.length())
                .append(words[words.length - 1]);
        for (int i = words.length - 2; i >= 0; i--) {
            String word = words[i].trim();
            if (!word.isEmpty())
                sb.append(' ').append(words[i]);
        }
        return sb.toString();
    }
}
