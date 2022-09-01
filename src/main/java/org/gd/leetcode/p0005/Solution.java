package org.gd.leetcode.p0005;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * @see org.gd.leetcode.p0226.Solution
 */
@SuppressWarnings({"JavadocReference"})
@LeetCode(
        name = "longest palindromic substring",
        state = LeetCode.State.DONE,
        difficulty = LeetCode.Level.MEDIUM,
        tags = {
                LeetCode.Tags.STRING,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        })
interface Solution {

    String longestPalindrome(String s);
}
