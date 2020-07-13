package org.gd.leetcode.p0409;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/longest-palindrome/
 *
 * @author Horkhover D.
 * @since 2020-07-13
 */
@LeetCode(
        name = "Longest Palindrome",
        state = LeetCode.State.DONE,
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.HASH_TABLE
        }
)
class Solution {

    public int longestPalindrome(String s) {
        final int length = s.length();
        final boolean[] arr = new boolean[128];
        int pLength = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (arr[c]) {
                arr[c] = false;
                pLength += 2;
            } else {
                arr[c] = true;
            }
        }
        return Math.min(length, pLength + 1);
    }
}
