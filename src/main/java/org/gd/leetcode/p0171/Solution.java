package org.gd.leetcode.p0171;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 *
 * @see org.gd.leetcode.p0168.Solution
 * @since 2019-10-04
 */
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.EASY, tags = LeetCode.Tags.MATH)
class Solution {

    private static final int RADIX = 'Z' - 'A' + 1;

    public int titleToNumber(String s) {

        if (s == null)
            throw new NullPointerException();

        if (s.length() <= 0)
            throw new IndexOutOfBoundsException();

        if (s.length() == 1)
            return s.charAt(0) - 'A' + 1;

        int sum = 0;
        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            int i = c + 1 - 'A';
            sum = sum * RADIX + i;
        }

        return sum;
    }
}
