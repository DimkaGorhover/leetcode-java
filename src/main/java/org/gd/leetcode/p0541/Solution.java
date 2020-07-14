package org.gd.leetcode.p0541;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/reverse-string-ii/
 *
 * @author Horkhover D.
 * @since 2020-07-14
 */
@LeetCode(
        name = "Reverse String II",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.STRING
        }
)
class Solution {

    private StringBuilder sb;
    private String word;
    private int length;

    private void writeReverse(int startIndex, int endIndex) {

        endIndex = Math.min(length, endIndex);

        if (startIndex + 1 == endIndex) {
            sb.append(word.charAt(startIndex));
            return;
        }

        for (int i = endIndex -1; i >= startIndex; i--)
            sb.append(word.charAt(i));
    }

    public String reverseStr(String s, int k) {
        sb = new StringBuilder(length = s.length());
        word = s;

        boolean reverse = true;
        for (int i = 0; i < length; i += k) {
            if (reverse) {
                writeReverse(i, i + k);
                reverse = false;
            } else {
                sb.append(s, i, Math.min(length, i + k));
                reverse = true;
            }
        }

        return sb.toString();
    }
}
