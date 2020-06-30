package org.gd.leetcode.p0151;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = LeetCode.Tags.STRING
)
class Solution {

    public String reverseWords(String s) {
        if (s == null || (s = s.trim()).isEmpty())
            return "";
        String   word;
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder(s.length())
                .append(words[words.length - 1]);
        for (int i = words.length - 2; i >= 0; i--)
            if (!(word = words[i].trim()).isEmpty())
                sb.append(' ').append(word);
        return sb.toString();
    }
}
