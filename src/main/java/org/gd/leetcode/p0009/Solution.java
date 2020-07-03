package org.gd.leetcode.p0009;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * @see org.gd.leetcode.p0234.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Palindrome Number",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.MATH
)
class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        if (x < 10)
            return true;

        int num = x, reverse = 0;
        do {
            reverse = (reverse * 10) + (num % 10);
        } while ((num /= 10) > 0);

        return x == reverse;
    }
}
