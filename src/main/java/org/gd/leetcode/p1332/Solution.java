package org.gd.leetcode.p1332;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/remove-palindromic-subsequences/
 *
 * @author Horkhover Dmytro
 * @since 2021-03-11
 */
@LeetCode(
        name = "Remove Palindromic Subsequences",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.TODO,
        tags = LeetCode.Tags.STRING
)
class Solution {

    private static boolean isPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return true;
        }
        for (int i = 0; i < (length >> 1); i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public int removePalindromeSub(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        return isPalindrome(s) ? 1 : 2;
    }
}
