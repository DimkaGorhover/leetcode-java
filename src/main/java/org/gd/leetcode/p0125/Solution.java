package org.gd.leetcode.p0125;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
@LeetCode(
        name = "Valid Palindrome",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TWO_POINTERS,
                LeetCode.Tags.STRING
        }
)
class Solution {

    private static boolean isEqual(char c0, char c1) {
        int v0 = c0 - (c0 >= 'a' ? 'a' : 'A');
        int v1 = c1 - (c1 >= 'a' ? 'a' : 'A');
        return v0 == v1;
    }

    private static boolean isValid(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    public boolean isPalindrome(String s) {

        int i = 0, j = s.length() - 1;
        char c0, c1;

        while (i <= j) {
            if (!isValid(c0 = s.charAt(i))) {
                i++;
                continue;
            }
            if (!isValid(c1 = s.charAt(j))) {
                j--;
                continue;
            }
            if (!isEqual(c0, c1))
                return false;

            i++;
            j--;
        }

        return true;
    }
}
