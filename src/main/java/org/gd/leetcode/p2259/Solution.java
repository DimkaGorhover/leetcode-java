package org.gd.leetcode.p2259;

import org.gd.leetcode.common.LeetCode;

/**
 * <a href="https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/">LeetCode #2259: Remove Digit
 * From Number to Maximize Result</a>
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0402.Solution
 * @since 2023-10-09
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Remove Digit From Number to Maximize Result",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.STRING,
                LeetCode.Tags.GREEDY,
                LeetCode.Tags.ENUMERATION,
        }
)
class Solution {

    public String removeDigit(String number, char digit) {
        int n = number.length();
        int pos = n - 1;
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                pos = i;
                if (i + 1 < n && number.charAt(i + 1) > digit) {
                    break;
                }
            }
        }
        char[] chars = new char[n - 1];
        for (int i = 0, j = 0; i < n; i++) {
            if (i != pos) {
                chars[j++] = number.charAt(i);
            }
        }

        return new String(chars);
    }
}
