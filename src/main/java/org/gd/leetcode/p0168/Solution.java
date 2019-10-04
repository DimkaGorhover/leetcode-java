package org.gd.leetcode.p0168;

import org.gd.leetcode.common.LeetCode;

// @formatter:off
/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * Example 1: 1 --> "A"
 *
 * Example 2: 28 --> "AB"

 * Example 3: 701 --> "ZY"
 *
 * @see org.gd.leetcode.p0171.Solution
 * @since 2019-10-03
 */
// @formatter:on
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.EASY, tags = LeetCode.Tags.MATH)
class Solution {

    private static final int RADIX = 'Z' - 'A' + 1;

    private static int length(int n) {
        int length = 0;
        for (; n > 0; length++)
            n = (n - 1) / RADIX;
        return length;
    }

    static String recursive(int n) {
        if (n <= 0)
            throw new IndexOutOfBoundsException();
        if (n < 27)
            return "" + ((char) ('A' + n - 1));
        int i = (n - 1) % RADIX;
        char c = (char) ('A' + i);
        return recursive((n - 1) / RADIX) + c;
    }

    static String loop(int n) {
        if (n <= 0)
            throw new IndexOutOfBoundsException();
        if (n < 27)
            return "" + ((char) ('A' + n - 1));

        char[] chars = new char[length(n)];
        int index = chars.length - 1;

        while (n > 0) {
            int i = (n - 1) % RADIX;
            char c = (char) ('A' + i);
            chars[index--] = c;
            n = (n - 1) / RADIX;
        }
        return new String(chars);
    }

    public String convertToTitle(int n) {
        return loop(n);
    }
}
