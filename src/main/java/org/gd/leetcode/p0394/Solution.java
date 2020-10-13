package org.gd.leetcode.p0394;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/decode-string/
 */
@LeetCode(
        name = "Decode String",
        state = LeetCode.State.DONE,
        difficulty = LeetCode.Level.MEDIUM,
        tags = {
                LeetCode.Tags.STACK,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    private StringBuilder sb;

    public String decodeString(String s) {

        if (s == null) {
            return null;
        }

        if (s.isEmpty()) {
            return "";
        }

        sb = new StringBuilder();
        _decodeString(s, 0, s.length());
        return sb.toString();
    }

    private static int findLast(String s, int startIndex, int endIndex) {
        int open = 1;
        for (int i = startIndex; i < endIndex; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                open++;
            } else if (c == ']') {
                open--;
            }
            if (open == 0) {
                return i;
            }
        }
        throw new IllegalArgumentException("input string is not valid ( " + s + " )");
    }

    private void _decodeString(String s, int startIndex, int endIndex) {

        if (endIndex - startIndex <= 0) {
            return;
        }

        if (endIndex - startIndex == 1) {
            sb.append(s.charAt(startIndex));
            return;
        }

        int digit = 0;
        for (int i = startIndex; i < endIndex; i++) {
            char c = s.charAt(i);
            if (c == ']') {
                continue;
            }
            if (Character.isDigit(c)) {
                digit = digit * 10 + Character.digit(c, 10);
            } else if (c == '[') {
                int last = findLast(s, i + 1, endIndex);
                while (digit > 0) {
                    _decodeString(s, i + 1, last);
                    digit--;
                }
                i = last;
            } else {
                sb.append(c);
            }
        }
    }
}
