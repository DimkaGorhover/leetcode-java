package org.gd.leetcode.p0132;

import org.gd.leetcode.common.LeetCode;

/**
 * TODO: https://leetcode.com/problems/palindrome-partitioning-ii/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0131.Solution
 * @since 2020-07-13.07.2020
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Palindrome Partitioning II",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.TIME_LIMIT_EXCEEDED,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class Solution {

    private int min;

    @SuppressWarnings("DuplicatedCode")
    private static boolean isPalindrome(String word) {
        final int length = word.length();
        if (length == 0)
            return false;
        if (length == 1)
            return true;
        int mid = length >> 1;
        for (int i = 0; i <= mid; i++) {
            int j = length - 1 - i;
            if (word.charAt(i) != word.charAt(j))
                return false;
        }
        return true;
    }

    private void partition(final int cuts,
                           final String word) {

        final int wordLength = word.length();
        if (wordLength == 0) {
            min = Math.min(min, cuts - 1);
            return;
        }
        if (wordLength == 1) {
            min = Math.min(min, cuts);
            return;
        }

        for (int i = 1; i <= wordLength; i++) {
            String ss = word.substring(0, i);
            if (isPalindrome(ss)) {
                partition(cuts + 1, word.substring(i, wordLength));
            }
        }
    }

    public int minCut(String word) {
        min = Integer.MAX_VALUE;
        partition(0, word);
        return min;
    }
}
